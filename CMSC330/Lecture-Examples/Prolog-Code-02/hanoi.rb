def move(size, from, dest, other)
    if size == 1
		disk = from.pop
		puts "Move top disk #{disk} from #{from.first} to #{dest.first}"
		dest.push disk
		puts from.inspect
		puts dest.inspect
		puts other.inspect
    else
		move(size-1, from, other, dest)
		move(1, from, dest, other)
		move(size-1, other, dest, from)
    end
end
  
a = ["A"]
b = ["B"]
c = ["C"]
a.push 3
a.push 2
a.push 1

puts a.inspect
puts b.inspect
puts c.inspect

move(3, a, b, c)
	