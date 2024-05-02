`timescale 1ns / 1ps

module clk1K(
	input clk,
	output clk1k
    );
	 
	wire clr;
	wire [15:0] q;
	 
	counter #(.N(16)) cnt16 (.clk(clk),.clr(clr),.q(q));	
	assign clr = 1'b0;
	assign clk1k = q[15];
endmodule
