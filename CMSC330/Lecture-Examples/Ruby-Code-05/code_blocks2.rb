# Ref: http://www.ruby-doc.org/core-1.9.3/ 

s = "Student,Sally,099112233,A"
s.each_line(',') { |x| puts x }
