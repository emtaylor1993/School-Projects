#!/usr/bin/ruby

# Arguments stored in predefined array variable $*
# Pass four arguments (e.g., 10 20 Jose Mary)
puts ARGV[0]
puts $*[1]
puts $*[2]
puts ARGV[3]

print "Type for the argument: "
puts ARGV[0].class
