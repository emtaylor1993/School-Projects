`timescale 1ns / 1ps

module booth_multiplier_test;
	// Inputs
	reg [3:0] a;
	reg [3:0] b;

	// Outputs
	wire [7:0] product;

	// Instantiate the Unit Under Test (UUT)
	booth_multiplier uut (
		.product(product), 
		.a(a), 
		.b(b)
	);
	
	integer i = 0;
	initial begin
		// Initialize Inputs
		a = 0000;
		b = 0000;

		// Wait 100 ns for global reset to finish
		#100;
        
		// Add stimulus here
		for (i = 0; i < 16; i = i + 1)
		begin
			a = i;
			b = i;
			#10 $display("a b = %b %b", a, b);
		end
	end
endmodule

