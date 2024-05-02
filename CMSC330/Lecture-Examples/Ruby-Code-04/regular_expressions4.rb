#!/usr/bin/ruby

# Example student info: 123 John
student_info_reg_exp = /(\d\d\d)\s+([a-zA-Z]+)/

print "Enter student info (id firstname): "
input_data = gets.chomp!
match_data_object = student_info_reg_exp.match(input_data)
if (match_data_object == nil) 
    puts "Wrong format"
else
    puts "Matched string: " + match_data_object[0];
    puts "First matched group: " + match_data_object[1]
    puts "Second matched group: " +  match_data_object[2]
end

