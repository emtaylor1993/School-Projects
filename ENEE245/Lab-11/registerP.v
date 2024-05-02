`timescale 1ns / 1ps

module registerP #(parameter N = 4)(
	input reset,
	input clk,
	input ldp,
	input [2*N-1:0] D,
	output reg [2*N-1:0] P
   );
	
	always@ (posedge clk) begin
		if(reset)
			P <= 0;
		else begin
			if(ldp) P<= D;
		end
	end
endmodule
