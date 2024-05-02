#!/usr/bin/env/ ruby -w

require 'monitor'

class BoundedBuffer
	def initialize(capacity)
		@arr = []
		@capacity = capacity
		@monitor = Monitor.new
		@consumersCond = @monitor.new_cond()
		@producersCond = @monitor.new_cond()
	end
	
	def consume() # remove element from the array and return it
		element = nil
		
		@monitor.synchronize do # lock
			@consumersCond.wait_while { @arr.empty? }
			element = @arr.shift() # remove from the front
			@producersCond.broadcast()
			
			puts "Thread #{Thread.current} has consumed #{element}."
			$stdout.flush()
		end # unlock
		
		return element
	end
	
	def produce(element) # add an element to the array
		@monitor.synchronize do # lock
			@producersCond.wait_until { @arr.length < @capacity }
			@arr.push(element) # add to the end
			@consumersCond.broadcast()
			
			puts "Thread #{Thread.current} has produced #{element}."
			$stdout.flush()
		end # unlock
	end
end


##########################################################

n = 5
c = 3
consumerThreads = []
producerThreads = []
buffer = BoundedBuffer.new(c)

n.times do
	consumerThreads.push(
		Thread.new do
			sleep(0.5)
			buffer.consume()
		end
	)
end

n.times do |i|
	producerThreads.push(
		Thread.new do
			sleep(0.5)
			buffer.produce(n-i)
		end
	)
end

consumerThreads.each do |t|
	t.join()
end

producerThreads.each do |t|
	t.join()
end
