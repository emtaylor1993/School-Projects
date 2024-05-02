`timescale 1ns/10ps

module ccu(clk, reset, A, B, sum, cout);

	input clk, reset;
	input [1:0] A, B;
	output [1:0] sum;
	output cout;

	/* Make sure the counter does not go past 2. */
	wire [1:0] count;
	wire rst;
	assign rst = reset;

	/* Define outputs for the multiplexers. */
	wire [1:0] m_out1, m_out2;

	counter c1(.clk(clk), .reset(rst), .out(count));
	mux m1(.Select(count[1]), .X(A), .Y(B), .Out(m_out1));

	mux m2(.Select(count[0]), .X(B), .Y(A), .Out(m_out2));
	adder a1(.A(m_out1), .B(m_out2), .Sum(sum), .Cout(cout));

endmodule
