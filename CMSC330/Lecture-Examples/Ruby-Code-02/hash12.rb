# Hash -> associative array
# Rlements can be indexed by any kind of values
# Every object has a hash key (Object class has a hash method)
# Constructor Hash.new
# Ref: http://www.ruby-doc.org/core-1.9.3/Hash.html

eng_to_spa = Hash.new

eng_to_spa["friend"] = "amigo"
eng_to_spa["house"] = "casa"
eng_to_spa["doctor"] = "doctor"

puts "Single entry: #{eng_to_spa["friend"]}"

puts "Hash values"
puts eng_to_spa.to_s
puts "Keys"
puts eng_to_spa.keys
puts "Values"
puts eng_to_spa.values

puts "\nDefinition"
b = Hash["a", 10, "b", 20]
puts b.to_s

c = Hash["c" => 30, "d" => 40]
puts c.to_s

credits = { "cmsc131" => 4, "cmsc330" => 3}
puts credits.to_s

puts "Dictionary"
eng_to_spa.keys.each { 
    |key| puts "English: #{key}, Spanish: #{eng_to_spa[key]}" 
} 

