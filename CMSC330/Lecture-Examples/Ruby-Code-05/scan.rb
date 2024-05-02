# Input two lines:
# Line1: The names are Jose 10 and Tom 30 
# Line2: Rose 20
# Press CTRL-D for EOF

total_owed = 0
while (line = gets) 
    line.scan(/(\w+)\s+([0-9]\d*)/) { |name, amount|
        puts "#{name} #{amount.to_i}"
        total_owed += amount.to_i
    }
end
puts "Total: #{total_owed}"
