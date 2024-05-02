#!/usr/bin/env/ ruby -w

# Fall 2009, Practice 7, Problem 2
#

require 'monitor'

class MyBarrier
	def initialize(n)
		@n = n
		@count = 0
		@monitor = Monitor.new
		@cond = @monitor.new_cond()
	end
	
	def enter()
		@monitor.synchronize do # lock
			puts "Thread #{Thread.current} is waiting."
			$stdout.flush()
			
			@count = @count + 1
			
			if @count < @n
				@cond.wait_while { @count < @n }
			else
				@cond.broadcast()
			end
			
			puts "Thread #{Thread.current} got through."
			$stdout.flush()
		end # unlock
	end
	
	def reset()
		@monitor.synchronize do # lock
			@count = 0
		end # unlock
	end
end


##########################################################

n = 5
threads = []
barrier = MyBarrier.new(n)

n.times do
	threads.push(
		Thread.new do
			sleep(0.5)
			barrier.enter()
		end
	)
end

threads.each do |t|
	t.join()
end
