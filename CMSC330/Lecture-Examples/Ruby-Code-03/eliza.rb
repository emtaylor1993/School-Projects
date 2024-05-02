#!/usr/bin/ruby -w

greeting = <<END
Hello, I am ELIZA.  I am a real person, honest!  
I am really concerned with your well-being. 
Please tell me all your problems.
END

puts greeting

problems = []

while inputline = gets
    if inputline =~ /(the [A-Za-z]+)/
        noun = $1
        problems.push(noun)
        print "But how does #{noun} make you FEEL?\n"
    else
        if rand(2) == 0 || problems.length == 0
            print "OK. Go on.\n"
        else
            randomproblemnumber = rand(problems.length)
            myproblem = problems[randomproblemnumber]
            print "Let's talk about issues with #{myproblem} a little more now.\n"
        end
    end
end

