#!/usr/bin/env/ ruby -w

# Fall 2010, Final Exam, Problem 13.c
#

require 'monitor'

class Container
	def initialize()
		@buf = nil
		@monitor = Monitor.new
		@cond = @monitor.new_cond()
	end
	
	def put(x)
		@monitor.synchronize do # lock
			if (@buf != nil)
				raise "FullException"
			end
			
			@buf = x
		end # unlock
	end
	
	def get()
		x = nil
		
		@monitor.synchronize do # lock
			if (@buf == nil)
				raise "EmptyException"
			end
			
			x = @buf
			@buf = nil
		end # unlock
		
		return x
	end
	
	def store(x)
		@monitor.synchronize do # lock
			@cond.wait_while { @buf != nil }
			@buf = x
			@cond.broadcast()
		end # unlock
	end
	
	def take()
		x = nil
		
		@monitor.synchronize do # lock
			@cond.wait_while { @buf == nil }
			
			x = @buf
			@buf = nil
			
			@cond.broadcast()
		end # unlock
		
		return x
	end
end
