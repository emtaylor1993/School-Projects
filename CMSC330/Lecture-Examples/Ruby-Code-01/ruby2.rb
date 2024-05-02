# Function example

printMessage("terp mascot love it", 3);
print max(10, 30);

def printMessage mes, times
    x = 1
    while x <= times
        puts mes
        x += 1
    end
end

def max(x, y) 
    if x > y 
        return x
    else
        return y
    end
end

