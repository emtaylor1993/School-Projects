`timescale 1ns/10ps

module lab04_test;
	wire led_A, led_B, led_C, led_D, led_E, led_F, led_G;
	reg [2:0] in;

	integer descr;

	bssdc b1(led_A, led_B, led_C, led_D, led_E, led_F, led_G, in);

	initial begin
		descr = $fopen("out.txt");
		$fmonitor(descr, "led_A: %d, led_B: %d, led_C: %d, led_D: %d, led_E: %d, led_F: %d, led_G: %d, in: %b", led_A, led_B, led_C, led_D, led_E, led_F, led_G, in);
	end

	initial begin
		in = 2;
		#10
		in = 3;
	end
endmodule
	 

