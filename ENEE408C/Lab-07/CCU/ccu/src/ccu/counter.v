`timescale 1ns/10ps

/* 2-bit counter with a synchronous reset. */

module counter(clk, reset, out);

input clk, reset;
output reg [1:0] out;

initial begin
	out = 0;
end

always @ (posedge clk) begin
	if (reset) begin
		out = 0;
	end
	else if (out == 2'b10) begin
		out = 0;
	end
	else begin
		out = out + 1;
	end
end

endmodule
