`timescale 1ns / 1ps

module data_path_test;
	// Inputs
	reg clk;
	reg reset;
	reg enable_a;
	reg ld_shift_a;
	reg enable_b;
	reg ld_shift_b;
	reg LdP;
	reg psel;
	reg [3:0] A;
	reg [3:0] B;
		
	// Outputs
	wire [7:0] R;
	wire zero;
	wire lsb_b;
		
	// Instantiate the Unit Under Test (UUT)
	mult_datapath uut (
		.clk(clk), 
		.reset(reset), 
		.enable_a(enable_a), 
		.ld_shift_a(ld_shift_a), 
		.enable_b(enable_b), 
		.ld_shift_b(ld_shift_b), 
		.LdP(LdP), 
		.psel(psel), 
		.A(A), 
		.B(B), 
		.R(R), 
		.zero(zero), 
		.lsb_b(lsb_b)
	);
	
	integer iA, iB;
	integer i;
	integer result;
		
	initial begin
		// Initialize Inputs
		clk = 0;
		reset = 0;
		enable_a = 0;
		ld_shift_a = 0;
		enable_b = 0;
		ld_shift_b = 0;
		LdP = 0;
		psel = 0;
		A = 0;
		B = 0;
		
		// Wait 100 ns for global reset to finish
		#100;
		#10 enable_a = 1; enable_b = 1;
		
		for (iA = 0; iA < 16; iA = iA + 1) begin
			for (iB = 0; iB < 16; iB = iB + 1) begin
				A = iA; B = iB;
				#100;
				//The following is the waveform generation for a single case
				reset = 1; // enable and load numbers
				//At bit 0:
				#20 reset = 0;
				if(zero) result = 0;
				else begin
					//Set Psel
					for (i = 0; i < 5; i = i + 1) begin
						#20;
						LdP = 1;
						ld_shift_a = 1;
						ld_shift_b = 1;
					end
					LdP = 0;
					ld_shift_a = 0;
					ld_shift_b = 0;
					result = R;
				end
				$display("%d = %d * %d Correct Answer = %d", result, iA, iB, (iA*iB));
			end
		end
	end
	
	always begin
		#10; clk = ~ clk;
	end
endmodule

