#!/usr/bin/ruby

print "Enter sentence with done anywhere: "
if gets.chomp =~ /done/
    puts "done found (anywhere): #{$~}"
else
    puts "done (anywhere) not found"
end

print "Enter sentence with done at the end: "
if gets.chomp =~ /done$/
    puts "done found (at the end): #{$~}"
else
    puts "done (at the end) not found"
end

print "Enter sentence with done at the beginning: "
if gets.chomp =~ /^done/
    puts "done found (at the beginning): #{$~}"
else
    puts "done (at the beginning) not found"
end

print "Enter sentence exactly with done: "
if gets.chomp =~ /^done$/
    puts "only done found: #{$~}"
else
    puts "only done not found"
end
