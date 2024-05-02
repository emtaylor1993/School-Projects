`timescale 1ns / 1ps

module mult_datapath #(parameter N = 4)(
	input clk,
	input reset,
	input enable_a,
	input ld_shift_a,
	input enable_b,
	input ld_shift_b,
	input LdP,
	input psel,
	input [N-1:0] A,
	input [N-1:0] B,
	output [2*N-1:0] R,
	output zero,
	output lsb_b
	);

	wire [2*N-1:0] outA;
	wire [2*N-1:0] partialP;
	
	registerA regA(.reset(reset), .enable(enable_a), .ld_shift(ld_shift_a), .clk(clk), .D(A), .Q(outA));
	registerB regB(.reset(reset), .enable(enable_b), .ld_shift(ld_shift_b), .clk(clk), .D(B), .zero(zero), .lsb_b(lsb_b));
	add_mux add_mux0 (.A(outA), .B(R), .sel(psel), .Y(partialP));
	registerP regP(.reset(reset), .clk(clk), .ldp(LdP), .D(partialP), .P(R));
endmodule
