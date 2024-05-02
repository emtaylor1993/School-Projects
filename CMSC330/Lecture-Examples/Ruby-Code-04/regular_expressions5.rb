#!/usr/bin/ruby

# back references
# if a second search is performed all back references
# are reset to nil

print "Enter data using format:  Min: <value> Max: <value>: "
if gets.chomp! =~ /^Min: (\d+) Max: (\d+)$/
    min, max = $1, $2
    puts "Min: #{min}"
    puts "Max: #{max}"
else
    puts "Wrong format"
end
