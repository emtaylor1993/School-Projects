class Web_Site
    def initialize(name, users)
        @name = name
        @users = users
    end
 
    def to_s
        return "Site:" + @name + ", Users:" + @users.to_s
    end
 
    def increment_users(x)
        @users += x 
    end
 
    def copyright
        puts "\"cmsc330\" Productions"
    end
end
 
x = Web_Site.new("cs.umd.edu", 1000);
x.increment_users 20
puts x
x.copyright
puts x.inspect
 