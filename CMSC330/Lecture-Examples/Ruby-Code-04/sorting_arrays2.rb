num_array = [10, 5, 89, 9];

descending = num_array.sort { |x, y| y <=> x }
puts descending.to_s

names_array = ["Leonard", "Sheldon", "Howard", "Raj", "Penny"]
names_desc = names_array.sort { |x, y| y <=> x }
puts names_desc
