# similar to switch, but more powerful

value = 70

case value
    when 0..69 then 
        puts "D";
    when 70..79 then
        puts "C";
    when 80..89 then
        puts "B"
    when 90..100 then 
        puts "A"
    when String 
        puts "String value"
    else
        puts "Don't know what to do with #{value}"
end