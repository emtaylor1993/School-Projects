`timescale 1ns / 1ps

module mux2test;
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
	
	// Initialize Inputs
	initial begin
	a = 0;
	b = 1;
	s = 0;
	
	#100;
	
	s = 1;
	
	#100;
	
	s = 0;
	
	#100;
	
	s = 1;
	
	#100;
	
	s = 0;
	
	#100;
	
	s = 1;
	end
endmodule

