#!/usr/bin/ruby

languages_you_know = /Java|C|Assembly/

print "Enter a language you have used: "
choice = gets.chomp
if choice =~ languages_you_know
    puts "Valid language"
end

print "Enter goal screaming: "
goal_screaming = /go+al*/
if gets.chomp =~ goal_screaming
    puts "Good screaming"
end

# Do we need ()
# Try {3,5}, {3,}
beetlejuice_will_appear = /(bj){3}/
print "Make Bettle Juice appear: "
choice = gets.chomp
if choice =~ beetlejuice_will_appear
    puts "Bettlejuice here"
end