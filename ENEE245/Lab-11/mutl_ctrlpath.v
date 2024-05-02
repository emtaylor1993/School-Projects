`timescale 1ns / 1ps

module mutl_ctrlpath #(parameter N = 4)(
	input clk,
	input restart,
	input zero,
	output reg reset_datapath,
	output reg enable_a,
	output reg ld_shift_a,
	output reg enable_b,
	output reg ld_shift_b,
	output reg LdP,
	output reg [2:0] state,
	output complete
	);
	
	localparam LOAD = 0;
	localparam DONE = 5;
	localparam SHIFT1 = 1;
	localparam SHIFT4 = 4;
	
	
	// reg [2:0] state;
	reg last_restart;
	// wire restart_edge;
	
	// assign restart_edge = (~last_restart) & restart;
	assign complete = (state == DONE);
	
	// State transitions
	always @ (posedge clk) begin
		//last_restart <= restart;
		if(restart) begin	
			state <= LOAD;
			//test <= ~test;
		end
		else begin
			if(zero) state <= DONE;
			else begin
				if(state != DONE)
					state <= state + 1;
				else
					state <= state;
		   end
		end
	end
	
	always @ (*) begin
		if(state == LOAD) begin
			reset_datapath = 1; ld_shift_a = 0; ld_shift_b = 0; enable_a = 1;
			enable_b = 1; LdP = 0;
		end
		else if (state >= SHIFT1 && state <= SHIFT4) begin
			reset_datapath = 0; ld_shift_a = 1; ld_shift_b = 1;
			enable_a = 1; enable_b = 1; LdP = 1;
		end
		else begin
			reset_datapath = 0; ld_shift_a = 0; ld_shift_b = 0;
			enable_a = 0; enable_b = 0; LdP = 0;
		end
	end
endmodule
