`timescale 1ns / 1ps

module add_mux #(parameter N = 4)(
	input [2*N-1:0] A,
	input [2*N-1:0] B,
	input sel,
	output reg [2*N-1:0] Y
   );
	
	always @(*) begin
		if(sel) begin
			Y <= A + B;
		end
		else
			Y <= B;
	end
endmodule
