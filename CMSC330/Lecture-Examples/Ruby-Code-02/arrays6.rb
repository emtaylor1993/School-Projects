# Arrays: instances of class Array, can be heterogeneous
# indexed from 0, increase in size automatically
# Reference: http://www.ruby-doc.org/docs/ProgrammingRuby/html/ref_c_array.html 

x = Array.new
puts x.to_s

y = [10, 20, 30]
puts y.to_s
puts "Length: #{y.length} or #{y.size}"

puts "Comparing"
a = [10, 20, 30]
b = [10, 20, 30]
if a == b
    puts "same elements"
else
    puts "different elements"
end

puts "Growing"
y[9] = 40
puts y.to_s

puts "Deleting"
a = [7, 9, 11, 14, 15]
puts "Original"
puts a.to_s
a.delete_at(3) # delete element at index 3
puts a.to_s
a.delete(9) # delete element with value 9
puts a.to_s  # what if we just write a?

puts "Pushing/Popping"
# push, pop, shift, unshift modify the array
c = [10, "John", 40]
puts "Original: #{c}"
c.push("Mary")
puts "After pushing Mary #{c}"
d = c.pop
puts "Popped: #{d}"
puts "After popping #{c}"
s = c.shift
puts "Shifted: #{s}"
puts "After shifting #{c}"
c.unshift(s)
puts "After unshifting 10 #{c}"