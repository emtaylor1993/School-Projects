`timescale 1ns / 1ps

module hex7seg_case(
    input [3:0] x,
    output reg a,
    output reg b,
    output reg c,
    output reg d,
    output reg e,
    output reg f,
    output reg g
//	output [3:0] AN,
//	output wire [10:0] DLA
    );
	 
//	assign DLA = {a,b,c,d,e,f,g,x};
//	assign AN = 4'b1110;
	 
	always @(*)
		begin
			case(x)
			0:begin
				a = 0;
				b = 0;
				c = 0;
				d = 0;
				e = 0;
				f = 0;
				g = 1;
				end
			1:begin
				a = 1;
				b = 0;
				c = 0;
				d = 1;
				e = 1;
				f = 1;
				g = 1;
			end
			2:begin
				a = 0;
				b = 0;
				c = 1;
				d = 0;
				e = 0;
				f = 1;
				g = 0;
			end
			3:begin
				a = 0;
				b = 0;
				c = 0;
				d = 0;
				e = 1;
				f = 1;
				g = 0;
			end
			4:begin
				a = 1;
				b = 0;
				c = 0;
				d = 1;
				e = 1;
				f = 0;
				g = 0;
			end
			5:begin
				a = 0;
				b = 1;
				c = 0;
				d = 0;
				e = 1;
				f = 0;
				g = 0;
			end
			6:begin
				a = 0;
				b = 1;
				c = 0;
				d = 0;
				e = 0;
				f = 0;
				g = 0;
			end
			7:begin
				a = 0;
				b = 0;
				c = 0;
				d = 1;
				e = 1;
				f = 1;
				g = 1;
			end
			8:begin
				a = 0;
				b = 0;
				c = 0;
				d = 0;
				e = 0;
				f = 0;
				g = 0;
			end
			9:begin
				a = 0;
				b = 0;
				c = 0;
				d = 0;
				e = 1;
				f = 0;
				g = 0;
			end
			10:begin
				a = 0;
				b = 0;
				c = 0;
				d = 1;
				e = 0;
				f = 0;
				g = 0;
			end
			11:begin
				a = 1;
				b = 1;
				c = 0;
				d = 0;
				e = 0;
				f = 0;
				g = 0;
			end
			12:begin
				a = 0;
				b = 1;
				c = 1;
				d = 0;
				e = 0;
				f = 0;
				g = 1;
			end
			13:begin
				a = 1;
				b = 0;
				c = 0;
				d = 0;
				e = 0;
				f = 1;
				g = 0;
			end
			14:begin
				a = 0;
				b = 1;
				c = 1;
				d = 0;
				e = 0;
				f = 0;
				g = 0;
			end
			15:begin
				a = 0;
				b = 1;
				c = 1;
				d = 1;
				e = 0;
				f = 0;
				g = 0;
			end
			default:begin
				a = 0;
				b = 0;
				c = 0;
				d = 0;
				e = 0;
				f = 0;
				g = 0;
			end
			endcase
		end
endmodule
