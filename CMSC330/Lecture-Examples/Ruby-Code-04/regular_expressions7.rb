#!/usr/bin/ruby

# Data format example: John 123 M Rose 456 F

student_info_reg_exp_no_paren = /[a-zA-Z]+\s+\d\d\d\s+[MF]/
student_info_reg_exp_paren =  /([a-zA-Z]+)\s+(\d\d\d)\s+([MF])/

input_data = gets.chomp!
puts "No Paren"
array_of_matches = input_data.scan(student_info_reg_exp_no_paren)
puts array_of_matches.to_s

puts "Paren"
array_of_matches = input_data.scan(student_info_reg_exp_paren)
puts array_of_matches.to_s
