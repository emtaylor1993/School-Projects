`timescale 1ns / 1ps

module registerB #(parameter N = 4)(
    input reset,
	 input enable,
	 input ld_shift,
	 input clk,
	 input [N-1:0] D,
	 output lsb_b,
	 output zero
	 );
	 
	 reg [N-1:0] Q;
	 
	 assign lsb_b = Q[0];
	 assign zero = (Q==0);
	 
	 always @(posedge clk) begin
		if(enable) begin
			if(reset) Q <= D;
			else begin
				if(ld_shift)
					Q <= Q >> 1;
				else Q <= Q;
			end
		end
	 end
endmodule
