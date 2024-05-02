# Exceptions:
# Java      Ruby
# try{}     begin end
# catch{}   rescue or catch method
# finally   ensure
# throw     raise or throw method

print "Enter an integer: "
x = gets.to_i

begin
    y = 10 / x
    rescue ZeroDivisionError
        puts "Trying to divide by zero"
        exit
    ensure
        puts "Division attempted"
end
puts y