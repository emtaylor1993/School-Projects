`timescale 1ns/10ps

/* Binary to Seven Segment Display Converter. */

module bssdc(led_A, led_B, led_C, led_D, led_E, led_F, led_G, in);
	output led_A, led_B, led_C, led_D, led_E, led_F, led_G;
	input [2:0] in;
	
	reg A, B, C, D, E, F, G;

	always @(*) begin
		case (in)
			3'b000 : begin
				A = 0; B = 0; C = 0; D = 0; E = 0; F = 0; G = 0;
			end
			3'b001 : begin
				A = 0; B = 1; C = 1; D = 0; E = 0; F = 0; G = 0;
			end
			3'b010 : begin
				A = 1; B = 1; C = 0; D = 1; E = 1; F = 0; G = 1;
			end
			3'b011 : begin
				A = 1; B = 1; C = 1; D = 1; E = 0; F = 0; G = 1;
			end
			3'b100 : begin
				A = 0; B = 1; C = 1; D = 0; E = 0; F = 1; G = 1;
			end
			3'b101 : begin
				A = 1; B = 0; C = 1; D = 1; E = 0; F = 1; G = 1;
			end
			3'b110 : begin
			 	A = 1; B = 0; C = 1; D = 1; E = 0; F = 1; G = 1;
			end
			3'b111 : begin
 				A = 1; B = 1; C = 1; D = 0; E = 0; F = 0; G = 0;
			end
			default : $display("Input Error.");
		endcase
	end
	
	assign led_A = A;
	assign led_B = B;
	assign led_C = C;
	assign led_D = D;
	assign led_E = E;
	assign led_F = F;
	assign led_G = G;
endmodule	
