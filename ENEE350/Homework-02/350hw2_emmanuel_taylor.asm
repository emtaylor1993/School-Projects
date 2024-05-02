# "350hw2_emmanuel_taylor.asm" - FIBONACCI

# This is the main function. This function allows
# the user to edit the first line to select a 
# constant of their choice and call the fibonacci
# function.
main:
	addi	$a0, $zero, 5		# Load the constant of user's choice into the argument register a0.
	addi	$t0, $zero, 1		# Load the constant 1 into the temporary register t0.
	addi	$t1, $zero, 2		# Load the constant 2 into the temporary register t1.
	jal		fibonacci			# Call fibonacci function.
	j		done				# Terminate the program.

# This is the fibonacci function. This is where the
# recursion takes place. In this function, the two base
# cases will be checked followed by the third case which
# will recursively call fibonacci on any number greater 
# 1.	
fibonacci:
	beq	$a0, $zero, case1	# If $a0 is zero, jump to case1.
	beq	$a0, $t0, case2		# If $a1 is one, jump to case2.
	slt	$t2, $a0, $t1		# Checking whether $a0 is less than 2.
	beq	$t2, $zero, case3	# If $a0 is not less than 2, jump to case3.

# This is the first case of the fibonacci function.
# In this case, if the number that the user chooses
# happens to be zero, we'll return the value 0.
case1:
	move	$v0, $zero		# Return the value 0 into $v0.
	jr		$ra				# Terminate the program.

# This is the second case of the fibonacci function.
# In this case, if the number that the user chooses
# happens to be one, we'll return the value 1.	
case2:
	move	$v0, $t0		# Return the value 1 into $vo.
	jr		$ra				# Terminate the program.

# This is the third case of the fibonacci function.
# In this case, if the number chosen is bigger than 1,
# We'll recursively call fibonacci until we reach
# the base cases.
case3:
	addi	$sp, $sp, -12		# Make space on the stack for 3 variables.
	sw		$ra, 0($sp)			# Store the return address in the first register on the stack.
	sw		$a0, 4($sp)			# Store $a0 in the second register on the stack.
	
	sub		$a0, $a0, 1			# Calculate $a0 - 1 (N - 1).
	jal		fibonacci			# Jump and link to calculate Fib(N - 1).
	sw		$v0, 8($sp)			# Store $v0 in the third register on the stack.
	lw		$a0, 4($sp)			# Restore the value of $a0.
	
	sub		$a0, $a0, 2			# Calculate $a0 - 2 (N - 2).
	jal		fibonacci			# Jump and link to calculate Fib(N - 2).
	lw		$t3, 8($sp)			# Retrieve the N - 1 value.
	
	add		$v0, $v0, $t3		# Calculate Fib(N - 1) + Fib(N - 2).
	lw		$ra, 0($sp)			# Restore the return address.
	addi	$sp, $sp, 12		# Restore the stack pointer.
	jr		$ra

# This terminates the program.
done:
