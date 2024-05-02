# Function example

def info(x, y) 
    if x > y 
       puts "greater"
    elsif x == y 
       puts "same"
       printf("%d %s\n", 10, "Here in fantasy land")
    else
       puts "less"
    end
end
  
info(10, 10)