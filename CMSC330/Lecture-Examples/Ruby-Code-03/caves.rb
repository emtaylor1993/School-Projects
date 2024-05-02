#!/usr/bin/ruby -w

#Rank Name Country Depth Length
CaveList = <<END
1.  Mammoth Cave System                      USA               116m, 579364m
2.  Optimisticheskaya                        Ukraine            20m, 214000m
3.  Jewel Cave                               USA               181m, 207718m
4.  Holloch                                  Switzerland       941m, 189026m
5.  Lechuguilla Cave                         USA               478m, 180096m
6.  Wind Cave                                USA               198m, 176288m
7.  Fisher Ridge Cave System                 USA               108m, 172008m
8.  Siebenhengste-hohgant-Hohlensystem       Switzerland      1340m, 145000m
9.  Sistema Ox Bel Ha                        Mexico               m, 133439m
10. Ozernaya                                 Ukraine            20m, 122000m
END

#Creates an array of arrays with [Name, Country, Length]
#myList = CaveList.scan(/^\d+\.\s+(.+\S+)\s+(\w+)\s+\d*m\,\s+(\d+)m$/)
myList = CaveList.scan(/
^              #The beginning of the line
\d+            #1 or more digits
\.             #the period character
\s+            #1 or more spaces
(.+\S)         #The name of the cave, which must end with non-space
\s+            #Spaces
(\w+)          #The name of the country (can't have spaces)
\s+            #Spaces
\d*m\,         #Deepness (0 or more digits, letter m, comma)
\s+            #Spaces
(\d+)m         #Length
$              #End of the line
/x)            #x tells that we allow newlines, spaces and comments

puts "\nScanning the cave list, the resulting array is:"
myList.each {|array| puts array.inspect}

#Build a hash so we can efficiently add the length for each country
h = Hash.new(0)
myList.each do |name, country, length|
	h[country] += length.to_i
end

#Sorts by length into an array of arrays
countryLength = h.sort {|a,b| b[1] <=> a[1]}

puts "\nAmong the 10 largest caves, each country has:"
countryLength.each {|c,l| print "%-15s"%c, "%5d"%(l/1000*0.621).round, " miles\n"}
