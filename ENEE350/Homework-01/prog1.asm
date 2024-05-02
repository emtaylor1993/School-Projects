li $s0, 1		# The register $s0 holds the initial constant value 1 for x.
li $t0, 0		# The register $t0 holds the initial value 0 for our counter i.
li $s1, 5		# The register $s1 holds the upper loop bound constant 5.
loop:
beq $t0, $s1, end	# If t0 == 5 we are out of the loop.
addi $s0, $s0, 2	# If t0 does not equal 5, perform x = x + 2.
addi $t0, $t0, 1	# Increment $t0 by 1 for each iteration of the loop.
j   loop			# jump back to the beginning of the loop and try again.
end:
