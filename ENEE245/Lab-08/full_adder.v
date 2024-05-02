`timescale 1ns / 1ps

module full_adder(
    output S,
    output C_out,
	 input A,
	 input B,
	 input C_in
    );
	wire s1,c1,c2;
	half_adder HA1(s1,c1,A,B);
	half_adder HA2(S,c2,s1,C_in);
	or OG1(C_out, c1, c2);
endmodule
