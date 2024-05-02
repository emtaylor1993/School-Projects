#!/usr/bin/ruby -w

class Dfa
    # Constructor for the DFA
    def initialize
        @state = Hash.new(false)
        @final = Hash.new(false)
        @transition = {}
    end

    # Creates a new state
    def add_state(v)
        unless has_state?(v)
            @state[v] = true
            @transition[v] = {}
        end
    end

    # Returns true if the state exists
    def has_state?(v)
        @state[v]
    end

    # Set (or reset) the start state
    def set_start(v)
        add_state(v)
        @start = v
    end

    # Set (or reset) a final state
    def set_final(v, final = true)
        add_state(v)
        if final
            @final[v] = true
        else
            @final.delete(v)
        end
    end

    # Returns true if the state is final
    def is_final?(v)
        @final[v]
    end

    # Creates a new transition from v1 to v2 with symbol x
    # Any previous transition from v1 with symbol x is removed
    def add_transition(v1, v2, x)
        add_state(v1)
        add_state(v2)
        @transition[v1][x] = v2
    end

    # Get the destination state from v1 with symbol x
    # Returns nil if non-existent
    def get_transition(v1,x)
        if has_state?(v1)
            @transition[v1][x]
        else
            nil
        end
    end

    # Returns true if the dfa accepts the given string
    def accept?(s, current = @start)
        if s == ""
            is_final?(current)
        else
            dest = get_transition(current,s[0,1])
            if dest == nil
                false
            else
                accept?(s[1..-1], dest)
            end
        end
    end
end

# Prints s followed by pass (or fail) if b is true (or false)
def mytest(b, s)
    if b
        puts "#{s}: pass"
    else
        puts "#{s}: fail"
    end
end

d = Dfa.new
d.set_start(1)
d.set_final(2)

mytest(d.has_state?(1), "test1")
mytest(d.has_state?(2), "test2")
mytest(d.has_state?(3) == false, "test3")
mytest(d.is_final?(2), "test4")

d.add_transition(1,2,"a")
mytest(d.get_transition(1,"a") == 2, "test5")
mytest(d.get_transition(1,"x") == nil, "test6")

d.add_transition(1,1,"b")
mytest(d.get_transition(1,"b") == 1, "test7")

mytest(d.accept?("bbba"), "test8")
mytest(d.accept?("a"), "test9")
mytest(d.accept?("xyz") == false, "test10")
mytest(d.accept?("") == false, "test11")
