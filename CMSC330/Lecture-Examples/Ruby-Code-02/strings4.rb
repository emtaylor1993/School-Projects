# new line
puts
super_hero = "Batman"    # can also use single quotes
message = "The best super_hero at #{Time.now} is #{super_hero}"
puts message

# Notice we are using single quotes
message2 = 'The best super_hero at #{Time.now} is #{super_hero}'
puts message2

# Here-documents
s=<<END
This will allow Joseph "Joe" Smith\n
to finish the task\n
on time 
END
puts s

# newline
puts
# closing symbol has to be on its own
s2=<<BANANA
This will allow a minion \n
to each bananas
BANANA
puts s2
