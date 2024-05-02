`timescale 1ns/10ps

/* Structural Histogram. */

module structural_hist(o1, o2, o3, o4, b1, b2, n);
	output [2:0] n;
	input [7:0] o1, o2, o3, o4, b1, b2;

	wire out1, out2, out3, out4;
	wire xnor_out1, or_out1, xor_out1, and_out1;
	wire xnor_out2, or_out2, xor_out2, and_out2;
	wire xnor_out3, or_out3, xor_out3, and_out3;
	wire xnor_out4, or_out4, xor_out4, and_out4;

	/* Observation 1. */	
	xor x1(xor_out1, o1, b1);
	xnor xn1(xnor_out1, b1, 0);
	or or1(or_out1, xnor_out, 1);
	and a1(and_out1, xor_out1, or_out1);
	not n1(out1, and_out1);	

	/* Observation 2. */
	xor x2(xor_out2, o2, b1);
	xnor xn2(xnor_out2, b1, 0);
	or or2(or_out2, xnor_out2, 1);
	and a2(and_out2, xor_out2, or_out2);
	not n2(out2, and_out2);

	/* Observation 3. */
	xor x3(xor_out3, o3, b1);
	xnor xn3(xnor_out3, b1, 0);
	or or3(or_out3, xnor_out3, 1);
	and a3(and_out3, xor_out3, or_out3);
	not n3(out3, and_out3);

	/* Observation 4. */
	xor x4(xor_out4, o4, b1);
	xnor xn4(xnor_out4, b1, 0);
	or or4(or_out4, xnor_out4, 1);
	and a4(and_out4, xor_out4, or_out4);
	not n4(out4, and_out4);
	
	assign n = out1 + out2 + out3 + out4;
endmodule	
