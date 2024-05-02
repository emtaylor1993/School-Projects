`timescale 1ns / 1ps

module anode_drv(
	input clk,
	input reset,
	input ce,
	output reg [1:0] sel,
	output reg [3:0] AN
    );
	
	always @(posedge clk or posedge reset)
		begin
			if (reset)
				sel <= 0;
			else if (sel < 4)
				sel <= sel+1;
			else
				sel <= 0;
		end
	
	always @(*)
		begin
			case(sel)
			0: AN = 4'b1110;
			1: AN = 4'b1101;
			2: AN = 4'b1011;
			3: AN = 4'b0111;
			default: AN = 4'b1110;
			endcase
		end
endmodule
