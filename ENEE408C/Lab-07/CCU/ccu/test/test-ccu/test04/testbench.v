`timescale 1ns/10ps

module testbench;

	// Inputs
	reg clk;
	reg reset;
	reg [1:0] A;
	reg [1:0] B;

	// Outputs
	wire [1:0] sum;
	wire cout;

	// Test Variables
	integer descr;

	// Instantiates the Unit Under Test (UUT);
	ccu uut(.clk(clk), .reset(reset), .A(A), .B(B), .sum(sum), .cout(cout));

	initial begin
		descr = $fopen("out.txt");
		$fmonitor(descr, "Clock: %d, A: %d, B: %d, Output: %d", clk, A, B, {cout, sum});
	end

	initial begin
		A = 1; B = 0; clk = 1; reset = 0;
		#35 $finish;
	end

	always begin
		#5 clk = ~clk;
	end
endmodule
