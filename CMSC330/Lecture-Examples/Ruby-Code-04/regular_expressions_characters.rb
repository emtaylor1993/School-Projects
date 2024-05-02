#!/usr/bin/ruby

# Reference: http://www.ruby-doc.org/core-2.0.0/Regexp.html
# A character class is delimited with square brackets ([, ]) 
# and lists characters that may appear at that point in the match.
#  /[ab]/ means a or b, as opposed to /ab/ which means a followed by b.

# What happens if we enter bla--- or ---bla ?? How to fix it? ^ $

valid_java_id = /[a-zA-Z_\$][a-zA-Z_\$0-9]*/
print "Enter a valid Java identifier: "
if gets.chomp =~ valid_java_id
    puts "#{$~} is a valid C identifier"  # $~ corresponds to the match
else
    puts "Invalid"
end