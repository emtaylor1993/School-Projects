`timescale 1ns/10ps

/* 2-bit counter with a synchronous reset. */

module counter(clk, reset, out);

input clk, reset;
output reg [1:0] out;

initial out = 0;

always @ (posedge clk) begin 
	if (reset) 
		out = 0;
	else
		out = out + 1;
end

endmodule

