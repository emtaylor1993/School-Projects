a = "Sheldon"
b = "Leonard"
c = "Sheldon"

puts "a: #{a}";
puts "b: #{b}";
puts "c: #{c}";
puts "a <=> b: #{a <=> b}"
puts "a <=> b: #{b <=> a}"
puts "a <=> c: #{a <=> c}"

# Defining array
data = ["Sheldon", "Leonard", "Penny"]
puts data.to_s

data.sort! 
puts "After first sort: #{data.to_s}"

data = ["Sheldon", "Leonard", "Penny"]
data.sort!{ |x,y| -1 * (x <=> y) }
puts "After second sort: #{data.to_s}"

data = ["Sheldon", "Leonard", "Penny"]
data.sort!{ |x,y| y <=> x }
puts "After third sort: #{data.to_s}"
