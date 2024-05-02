`timescale 1ns / 1ps

module segment_ctr(
		input clk,
		input reset,
		input ce,
		input [3:0] a,
		input [3:0] b,
		input [3:0] c,
		input [3:0] d,
		output [3:0] AN,
		output [6:0] seg
	//	output [6:0] DLA
    );
	 
	wire clk1k;
	wire [1:0] sel;
	wire [3:0] x;
	 
	// assign DLA = {clk1k,sel,AN};
	
	 
	//Sequential_Multiplier
	clk1K clkconveter(.clk(clk),.clk1k(clk1k));
	anode_drv anode_uut(.clk(clk1k),.reset(reset),.ce(ce),.sel(sel),.AN(AN));
	mux_41c mux_uut(.a(a),.b(b),.c(c),.d(d),.s(sel),.y(x));
	hex7seg_case decoder(.x(x),.a(seg[6]),.b(seg[5]),.c(seg[4]),.d(seg[3]),.e(seg[2]),.f(seg[1]),.g(seg[0]));
endmodule
