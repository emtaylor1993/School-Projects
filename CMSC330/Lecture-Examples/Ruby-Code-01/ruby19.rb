class Web_Site
    @@total = 0;
 
    def initialize(name, users)
       @name = name
       @users = users
       
       #increasing number of sites
       @@total += 1;
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
 
    # Notice this is a class method
    def Web_Site.get_total
       return @@total
    end
 end
 
 x = Web_Site.new("cs.umd.edu", 1000);
 x.increment_users 20
 puts x
 x.copyright
 puts x.inspect
 y = Web_Site.new("grace.umd.edu", 5000);
 puts "Total: " + Web_Site.get_total.to_s
 