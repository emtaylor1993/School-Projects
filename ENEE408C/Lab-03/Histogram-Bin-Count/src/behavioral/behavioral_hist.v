`timescale 1ns/10ps

/* Behavioral Histogram. */

module behavioral_hist(o1, o2, o3, o4, b1, b2, n);
	output [2:0] n;
	input [7:0] o1, o2, o3, o4, b1, b2;
	
	reg out1;
	reg out2;
	reg out3;
	reg out4;
	
	always @(*) begin
		out1 = 0;
		out2 = 0;
		out3 = 0;
		out4 = 0;
	end

	always @(*) begin
		if (o1 >= b1 && o1 <= b2) begin
			out1 = 1;
		end else begin
			out1 = 0;
		end
 
		if (o2 >= b1 && o2 <= b2) begin
			out2 = 1;
		end else begin
			out2 = 0;
		end
 
		if (o3 >= b1 && o3 <= b2) begin
			out3 = 1;
		end else begin
			out3 = 0;
		end

		if (o4 >= b1 && o4 <= b2) begin
			out4 = 1;
		end else begin
			out4 = 0;
		end
	end

	assign n = out1 + out2 + out3 + out4;
endmodule
