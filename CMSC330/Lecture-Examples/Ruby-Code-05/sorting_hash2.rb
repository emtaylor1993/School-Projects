# Reference: http://www.ruby-doc.org/docs/ProgrammingRuby/html/ref_c_hash.html
# To pratice regular expressions try: http://rubular.com/ 

friends_count = Hash.new
friends_count["Mary"] = 5
friends_count["John"] = 2
friends_count["Laura"] = 4

puts "\nOriginal Hash"
puts friends_count

# The sort method converts hash to a nested array of [ key, value ] arrays 
# and sorts it, using Array#sort
sorted_friends_count = friends_count.sort
puts "\nResult of sorting is an array"
puts sorted_friends_count.to_s

# To create a hash out of the array we can use the class method Hash[]
# Notice we are using [ ] not parentheses

sorted_hash = Hash[sorted_friends_count]
puts "\nSorted Hash"
puts sorted_hash
