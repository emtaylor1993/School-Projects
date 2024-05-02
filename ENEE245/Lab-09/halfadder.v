`timescale 1ns / 1ps

module halfadder(sout, cout, a, b);
	output sout, cout;
	input a, b;
	
	assign sout = a ^ b;
	assign cout = (a & b);
endmodule
