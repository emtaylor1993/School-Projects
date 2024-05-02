num_array = [10, 5, 89, 9];

puts "Original: " + num_array.to_s
puts "Sorted: " + num_array.sort.to_s
num_array.sort!
puts "Permanently Sorted: " + num_array.to_s
