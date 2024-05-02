`timescale 1ns / 1ps

module Sequential_Test;
	// Inputs
	reg clk;
	reg reset;
	reg [3:0] A;
	reg [3:0] B;

	// Outputs
	wire [7:0] Product;
	wire zero;
	wire reset_datapath;
	wire enable_a;
	wire enable_b;
	wire ld_shift_a;
	wire ld_shift_b;
	wire ldp;
	wire complete;
	wire psel;
	wire [2:0] state;

	// Instantiate the Unit Under Test (UUT)
	Sequential_Multiplier uut (
		.clk(clk), 
		.reset(reset), 
		.A(A), 
		.B(B), 
		.Product(Product),
		.zero(zero),
		.reset_datapath(reset_datapath),
		.enable_a(enable_a),
		.enable_b(enable_b),
		.ld_shift_a(ld_shift_a),
		.ld_shift_b(ld_shift_b),
		.ldp(ldp),
		.complete(complete),
		.psel(psel),
		.state(state)
	);

	integer i;
	integer j;
	initial begin
		// Initialize Inputs
		clk = 0;
		reset = 0;
		A = 0;
		B = 0;

		for (i = 0; i < 4; i = i + 1) begin
			A = i;
			for (j = 0; j < 4; j = j + 1) begin
				B = j;
			end
			
			reset = 1; #20;
			reset = 0; #20;
		end	
	end
	
	always begin
		#5; clk = ~clk;
	end
endmodule
