`timescale 1ns / 1ps

module mux21test;
	// Inputs
	reg [3:0] a;
	reg [3:0] b;
	reg s;

	// Outputs
	wire [3:0] z;

	// Instantiate the Unit Under Test (UUT)
	mux21 uut (
		.a(a), 
		.b(b), 
		.s(s), 
		.z(z)
	);

	initial begin
		// Initialize Inputs
		a = 0;
		b = 0;
		s = 0;

		// Wait 100 ns for global reset to finish
		#100;
        
		// Add stimulus here
	end
endmodule

