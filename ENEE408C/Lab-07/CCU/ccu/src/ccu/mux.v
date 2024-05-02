`timescale 1ns/10ps

module mux(Select, X, Y, Out);

	input Select;
	input [1:0] X, Y;
	output reg [1:0] Out;

	wire Select;
	wire [1:0] X, Y;

	always @ (*) begin
		if (Select == 1) 
			Out = Y;
		else
			Out = X;
	end

endmodule
