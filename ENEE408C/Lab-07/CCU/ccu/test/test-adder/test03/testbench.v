`timescale 1ns/10ps

module testbench;
	
	// Inputs
	reg [1:0] A;
	reg [1:0] B;

	// Outputs
	wire [2:0] Sum;

	// Test Variables
	integer descr;

	// Instantiate the Unit Under Test (UUT)
	adder uut(A, B, Sum);

	initial begin
		descr = $fopen("out.txt");
		$fmonitor(descr, "A: %d, B: %d, Sum: %d", A, B, Sum);
	end

	initial begin
		A = 3; B = 3;
	end
endmodule
