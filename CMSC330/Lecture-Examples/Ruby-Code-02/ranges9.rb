def even(x)
    (1..x).each{
        |k|
        if k % 2 == 0
            puts k
        end
    }
end
 
even(10)