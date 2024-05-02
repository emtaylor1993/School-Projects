#!/usr/bin/ruby

name = "bigbangtheory"
puts "\nIndex of b starting at 2: #{name.index("t", 2)}"

# replaces first occurence
answer = name.sub("b", "B");
puts "After replacing first b occurrence #{answer}"

answer = name.gsub("b", "B");
puts "After replacing all instances of b occurrence #{answer}"

cvs = "10%3%5"
cvs_array = cvs.split("%");
puts "cvs array #{cvs_array.to_s}"
