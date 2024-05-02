#!/usr/bin/ruby -w
# Run this program before looking at the code
# It teaches about different ways to write loops, but the code is written using eval,
# which runs Ruby code from a string. Multi-line strings use << construction.

puts "There are many ways to write a loop in Ruby. This program will show some."

def showLoop(l)
    gets

    puts "Code:"
    puts l,"\n"

    print "Result: "
    eval l
    puts ""
end

showLoop "5.times {|i| print i}\n"

showLoop <<LOOP
5.times do |i|
    print i
end
LOOP

showLoop "0.upto(4) {|i| print i}\n"

showLoop <<LOOP
for i in (0..4)
    print i
end
LOOP

showLoop "(0..4).each {|i| print i}\n"

showLoop <<LOOP
i=-1
print i+=1 while i<4
LOOP

showLoop <<LOOP
i=-1
print i+=1 until i==4
LOOP

showLoop <<LOOP
i=0
while i<5 do
    print i
    i+=1
end
LOOP

showLoop <<LOOP
i=0
loop do
    print i
    break if (i+=1)==5
end
LOOP