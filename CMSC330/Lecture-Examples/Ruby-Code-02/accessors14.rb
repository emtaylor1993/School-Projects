class Point
    def initialize(x, y)
        @x = x
        @y = y
    end
 
    def to_s
        return "(#{@x.to_s }, #{@y.to_s})"
    end
 
    # getters/setters
    attr_accessor "x", "y"
end

p = Point.new 7, 8
puts p.to_s
puts "x --> #{p.x}, y --> #{p.y}"

# Updating
p.x = 800;
p.y = 900;
puts "x --> #{p.x}, y --> #{p.y}"
  