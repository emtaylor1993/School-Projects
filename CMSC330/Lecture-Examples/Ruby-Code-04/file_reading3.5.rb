#!/usr/bin/ruby
# To run execute:
# ./file_reading4.5.rb friends.txt original
# ./file_reading4.5.rb friends.txt lineno

def process_file(filename, option = 1)
    begin 
        # Reading line by line
        data_file = File.open(filename, "r")

        if (option == 1)
            # notice using each_line instead of line
            data_file.each_line{ |line| puts "#{line}" }
        elsif (option == 2)
            data_file.each{ |line| puts "Line #{data_file.lineno}:  #{line}" }
        end

        rescue Exception => e
            puts "\n\nProblem!!!! #{e.to_s}\n\n"
            exit
    end
    # Closing the file
    data_file.close
end
 
def my_main()
    if ARGV.size != 2
        puts "You need a filename followed by request"
        exit
    end

    if ARGV[1] == "original"
        process_file(ARGV[0])
    elsif ARGV[1] = "lineno"
        process_file(ARGV[0], 2)
    else
        puts "Invalid option provided"
        exit
    end
end
 
# Starts processing
my_main();