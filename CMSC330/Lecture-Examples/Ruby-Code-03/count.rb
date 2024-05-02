#!/usr/bin/ruby -w

file = File.new(ARGV[0], "r")
lines = file.readlines
hash = Hash.new
lines.each{ |line|
    words = line.scan(/\S+/)
    words.each{ |word|
        if hash[word] == nil
            hash[word] = 1
        else
            hash[word] += 1
        end
    }
}

hash.keys.each {
    |key| puts("word: #{key}, count: #{hash[key]}")
}
