class Point
    def initialize(x, y)
        @x = x
        @y = y
    end
 
    def to_s
        return "(#{@x.to_s }, #{@y.to_s})"
    end
 
    # getters
    def x
        @x
    end
 
    def y
        @y
    end
 
    # setters
    def x=(new_value)
        @x = new_value
    end
 
    def y=(new_value)
        @y = new_value
    end
end

p = Point.new 3, 4
puts p.to_s
puts "x --> #{p.x}, y --> #{p.y}"

# Updating
p.x = 100;
p.y = 200;
puts "x --> #{p.x}, y --> #{p.y}"
