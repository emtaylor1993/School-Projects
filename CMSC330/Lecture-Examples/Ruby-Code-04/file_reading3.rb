# Reading from file

print "Enter filename: (default is friends.txt): "
filename = gets.chomp

begin 
    # Reading line by line
    data_file = File.open(filename, "r")

    data_file.each{ |line| puts "Line #{data_file.lineno}:  #{line}" }

    rescue Exception => e
        puts "\n\nProblem!!!! #{e.to_s}\n\n"
        exit
end

# Closing the file
data_file.close