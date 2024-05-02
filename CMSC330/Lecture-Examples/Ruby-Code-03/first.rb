#!/usr/bin/ruby -w

puts "This is a simple Ruby program."
puts "Please enter a string:"
str = gets
str = str.chomp    # Chomp is here to remove the newline.
puts "You entered: #{str}."

# If you like to do a lot in one line, then try:
# puts "You entered #{gets.chomp}."
