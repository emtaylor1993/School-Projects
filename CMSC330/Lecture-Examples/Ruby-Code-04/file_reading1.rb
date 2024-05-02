# Reading from file

print "Enter filename: (default is friends.txt): "
filename = gets.chomp

# Reading line by line
data_file = File.open(filename, "r")
while !data_file.eof
    line = data_file.readline
    puts line
    end

# Closing the file
data_file.close