	.data
size:	.word 10
list:	.word -4, 10, 6, 7, 7, 19, 3, 2, -6, 5
	.text
	
main:
	lw		$a1, size		# Get size of list and store it into $al.
	la		$t0, list		# Get the base address of the list and store it into $t0.
	mul 	$t3, $a1, 4		# Get the byte size of the list and stores it into $t7.
	move 	$a0, $t0 		# Copy the base address of the list into $a0.
	move 	$s0, $zero 		# Stores the constant 0 into $s0.
	
sort1: 
	add 	$t4, $0, $0 	# Indicates whether or not to sort the list.
	move 	$s2, $zero 		# Start the current position of the list at 0.
	addi 	$s3, $s2, 4 	# Start 4 bytes after the current position in the list.
	
sort2: 
	lw 		$t0, list($s2) 	# Get the current element from the list and store it in $t0.
	lw 		$t1, list($s3) 	# Get the next element from the list and store it in $t1.
	slt 	$t2, $t0, $t1 	# Check to see if the current element is smaller than the next element.
	beq 	$t1, $t0, skip	# If the current element is equal to the next element (sorted) skip.
	bne 	$t2, $s0, skip	# If the current element is less than the next element (sorted) skip.
	addi 	$t4, $t4, 1 	# Indicates whether the list should be checked again.
	sw 		$t0, list($s3) 	# Place the current element into the next element.
	sw 		$t1, list($s2) 	# Place the next element into the current element.
	
skip:
	addi	$s2, $s2, 4 	# Increment the current element.
	addi	$s3, $s3, 4		# Increment the next element.
	bne 	$s2, $t3, sort2 # Check whether the current element is at the end of the list. 
	bne 	$t4, $s0, sort1 # Check if the list needs to be sorted again.
	
end:
