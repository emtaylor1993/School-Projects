`timescale 1ns / 1ps

module mux_41c(
		input wire [3:0] a,
		input wire [3:0] b,
		input wire [3:0] c,
		input wire [3:0] d,
		input wire [1:0] s,
		output reg [3:0] y		
    );

	always @(*)
		case(s)
			0:	y = a;
			1:	y = b;
			2:	y = c;
			3:	y = d;
			default : y = a;
		endcase
endmodule
