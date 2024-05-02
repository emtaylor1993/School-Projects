#!/usr/bin/ruby

# student_info_reg_exp =  /([a-zA-Z]+)\s+(\d\d\d)\s+([MF])/

# What happens if you use " " instead of ' ' ?
name = '([a-zA-Z]+)'
id = '(\d\d\d)'
gender = '([MF])'
final = name + '\s+' + id + '\s+' + gender
puts "The reg expression to use: " + final
student_info_reg_exp = Regexp.new(final)

input_data = gets.chomp!
match_object = input_data.match(student_info_reg_exp)
if match_object   
    puts match_object[1]
    puts match_object[2]
    puts match_object[3]
else
    puts "Wrong format"
end
