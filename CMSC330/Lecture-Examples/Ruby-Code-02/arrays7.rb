a = [3, 8, 19]
i = 0

while i < a.length
    puts a[i]

    i += 1
end

# better way
# code block delimeted by { } or do end
puts "Using code block"
a.each { |y| puts y }

puts "Using code block (do/end)"
a.each do |x| puts x end
