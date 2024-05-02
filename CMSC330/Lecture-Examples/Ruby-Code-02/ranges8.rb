# Ref: http://www.ruby-doc.org/core-1.9.3/Range.html 
puts "Inclusive"
for i in (1..4)
    puts i
end

puts "Ignores last"
for i in (1...4)
    puts i
end

puts "Characters"
for i in ('a'..'d')
    puts i
end

puts "Other than integers"
a = (2.5..3.75)
puts "Does a includes 3.1? #{a.include? 3.1}"
# cannot iterate over floats

puts "Converting to array"
a = (10..15)
b = a.to_a  # converting
puts b.to_s

puts "Using each"
(10..15).each {
    |x|
    print "#{x} "
}
#new line
puts 