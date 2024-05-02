`timescale 1ns / 1ps

module anode_drv(
    input wire clk,
    input wire reset,
    output reg [1:0] O,
    output reg [3:0] AN
    );
	 
	 always @(posedge clk) begin
		if (reset) begin
			O <= 0;
			AN <= 4'b1110;
		end
		else begin
			O <= O+1;
			case(O)
				0: AN <= 4'b1110;
				1: AN <= 4'b1101;
				2: AN <= 4'b1011;
				3: AN <= 4'b0111;
			default: AN <= 4'b1110;
			endcase
		end
	end	
endmodule
