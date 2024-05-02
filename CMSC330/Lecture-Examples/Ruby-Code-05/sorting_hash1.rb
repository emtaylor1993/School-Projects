friends_count = Hash.new
friends_count["Sheldon"] = 2
friends_count["Penny"] = 10
friends_count["Leonard"] = 4

puts "\nOriginal Hash"
puts friends_count

puts "\nAfter first sorting"
sorted_array = friends_count.sort
puts sorted_array.to_s

puts "\nAfter second sorting (names ordered by number of friends)"
names = friends_count.keys
names.sort! { |x,y| friends_count[x] <=> friends_count[y] }
puts names.to_s

puts "\nPrinting names ordered by number of friends"
names.each { |x| puts "#{x} --> #{friends_count[x]}" }
