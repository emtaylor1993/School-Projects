`timescale 1ns/10ps

/* 2-bit adder module. */

module adder(A, B, Sum, Cout);
	input [1:0] A, B;
	output [1:0] Sum;
	output Cout;

	assign {Cout, Sum} = A + B;
endmodule
