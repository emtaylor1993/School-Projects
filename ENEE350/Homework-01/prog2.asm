		.data
size:	.word 10
list:	.word -4, 10, 6, 7, 7, 19, 3, 2, -6, 5
		.text
main:
	lw		$a1, size	# Get size of list
	la		$t0, list	# Get the address of the list
	move	$a0, $t0	# Copying list address to $a0
	move	$s1, $zero	# Set counter for # of elements compared
	move 	$s2, $zero	# Set offset from Array
	addi	$s3, $s2, 4	# Increment to the next position of the array
	li		$t3, 0		# Set constant 1 to $t3
	li		$v0, -4		# Setting first element of the list as a placeholder for $v0
	
max:
	bge	$s1, $a1, end	# Stop after last element is compared
	lw	$t1, list($s2)	# Get the current element from the list
	lw	$t2, list($s3)	# Get the next element from the list
	slt	$t4, $t1, $t2	# Checking if element in $t1 is less than element in $t2
	bne	$t3, $t4, if	# Condition1: branch if ($t3 == $t4)
	beq	$t3, $t4  else	# Condition2: branch if ($t3 != $t4)
	jr	$ra

if:
	move	$t5, $t2	# If $t2 is greater than $t1, place $t2 in $t5
	slt	$t6, $v0, $t5	# Checking if $v0 is less than $t5
	jal		check
	addi	$s1, $s1, 1	# Increment the loop counter
	addi	$s2, $s2, 4	# Step to the next element in the array
	addi	$s3, $s3, 4	# Step to the next element again.
	jal	max
	
else:	
	move	$t5, $t1	# If $t2 is less than $t1, place $t1 in $t5
	slt	$t6, $v0, $t5	# Checking if $v0 is less than $t5
	jal		check
	addi	$s1, $s1, 1	# Increment the loop counter
	addi	$s2, $s2, 4	# Step to the next element in the array
	addi	$s3, $s3, 4	# Step to the next element again.
	jal	max
	
check:	bne	$t6, $t3, swap	 # If the values are not the same, change the values
		beq	$t6, $t3, noswap # If the values are the same, do not change the values
	
swap:	move	$v0, $t5	# Switch the values
		jr		$ra			# Return to where we were
	
noswap:	jr	$ra  		# Return to where we were
	
end:
