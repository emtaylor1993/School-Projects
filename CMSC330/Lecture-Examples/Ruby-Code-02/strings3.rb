name1 = "Laura\n"
name2 = "Laura\n"
name3 = name1

if name1 == name2 then
    puts "Same Contents"
else
    puts "Different Contents"
end

# equal? inherited from the Object class 
if name1.equal? name2 then
    puts "Same Reference (name1 and name2)"
else
    puts "Different Reference (name1 and name2)"
end

if name1.equal?(name3) then
    puts "Same Reference (name1 and name3)"
else
    puts "Different Reference (name1 and name3)"
end

puts name1
puts "**** Step1"
puts name1.chomp
puts name1

puts "**** Step2"
print name1.chomp!
puts name1

puts "Done"
