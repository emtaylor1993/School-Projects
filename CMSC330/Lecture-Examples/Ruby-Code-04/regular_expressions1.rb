#!/usr/bin/ruby

# 
# Reference: http://www.ruby-doc.org/core-2.0.0/Regexp.html 
#
# 1. Regular expressions (regexps) are patterns which describe the 
# contents of a string.
#
# 2. Used to test whether a string contains a given pattern or
# extracting portions that match 
#
# 3. Created using literals /pattern/  %r{pattern} or Regexp.new
#
# 4. Pattern matching may be achieved by using =~ operator or #match method. 

mascot_reg_exp = /testudo/   # we could have used Regexp.new("testudo")

# Press CTRL-D to indicate EOF
prompt = "Enter line that includes MD mascot name: "
print prompt
while line = gets 
    answer = line =~ mascot_reg_exp
    if answer != nil 
        puts "\"#{line.chomp}\" has the mascot name"
        puts "Answer: #{answer}"
    end
    print prompt
end