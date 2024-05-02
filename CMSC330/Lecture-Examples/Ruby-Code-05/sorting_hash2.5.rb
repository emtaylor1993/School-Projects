friends_count = Hash.new
friends_count["Sheldon"] = 2
friends_count["Penny"] = 10
friends_count["Leonard"] = 4

puts "\nOriginal Hash"
puts friends_count

puts "\nAfter first sorting"
sorted_array = friends_count.sort { |x,y| (x[1] <=> y[1]) }
puts sorted_array.to_s
