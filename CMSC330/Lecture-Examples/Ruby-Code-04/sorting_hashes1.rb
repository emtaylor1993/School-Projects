#!/usr/bin/ruby

# If a key does not exist in the hash nil is returned
# We can change the default in the constructor
eng_spa = Hash.new("Don't know word in Spanish");

eng_spa["friend"] = "amigo"
eng_spa["house"] = "casa"
eng_spa["blue"] = "rojo"

puts "Attempting non-existing key (\"yellow\"): "
puts eng_spa["yellow"]

puts "\n\nOriginal:"
eng_spa.each_pair { |key, value| puts "#{key}-->#{value}" }

puts "\n\nSorted by Key:"
sorted_by_key = eng_spa.sort
puts sorted_by_key.to_s
puts
