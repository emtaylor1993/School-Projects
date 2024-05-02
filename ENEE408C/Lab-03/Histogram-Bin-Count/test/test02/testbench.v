`timescale 1ns/10ps

module testbench;
	reg [7:0] o1;
	reg [7:0] o2;
	reg [7:0] o3;
	reg [7:0] o4;
	reg [7:0] b1;
	reg [7:0] b2;
	wire [2:0] n;

	integer descr;

	behavioral_hist h1(o1, o2, o3, o4, b1, b2, n);

	initial begin
		descr = $fopen("out.txt");
		$fmonitor(descr, "o1: %d, o2: %d, o3: %d, o4: %d, b1: %d, b2: %d, n: %d", o1, o2, o3, o4, b1, b2, n);
	end

	initial begin
		o1 = 0; o2 = 4; o3 = 1; o4 = 1; b1 = 0; b2 = 3;
		#10
		o1 = 1; o2 = 12; o3 = 3; o4 = 11; b1 = 0; b2 = 9;
	end
endmodule

