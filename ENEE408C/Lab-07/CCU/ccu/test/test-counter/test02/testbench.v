`timescale 1ns/10ps

module testbench;

	// Inputs
	reg clk;
	reg reset;

	// Outputs
	wire [1:0] out;

	// Test Variables
	integer descr;

	// Instantiate the Unit Under Test (UUT)
	counter uut(clk, reset, out);

	initial begin
		descr = $fopen("out.txt");
		$fmonitor(descr, "Clk: %d, Reset: %d, Out: %d", clk, reset, out);
	end

	initial begin
		clk = 0;
		reset = 0;
		#15 reset = 1;
		#5 reset = 0;
		#25 $finish;
	end

	always begin
		#5 clk = ~clk;
	end
endmodule
