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
 
class Super_Web_Site < Web_Site 
    def initialize(name, users, super_index)
        super(name, users)
        @super_index = super_index
    end   
 
    def to_s
        return super + ", Index: " + @super_index.to_s
    end
end

s_site = Super_Web_Site.new "cs.umd.edu", 10, 9
puts s_site

s_site.increment_users 4
puts s_site