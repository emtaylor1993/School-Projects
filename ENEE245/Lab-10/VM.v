`timescale 1ns / 1ps

module VM(
    input clk,
    input reset,
    input [2:0] coin,
    input [3:0] select,
    output [3:0] AN,
    output [6:0] seg,
    output [3:0] product
    );
	 
	wire [24:0] q; 
	wire [7:0] price,total_money;
	
	counter #(25) M1(.clk(clk),.clr(1'b0),.q(q));
	VendingMachine M2(
		.clk(q[24]),
		.reset(reset),
		.coin(coin),
		.select(select),
		.product(product),
		.total_money(total_money),
		.price(price)	
	);
	
	segment_ctr M3(.clk(clk),.reset(reset),.ce(1'b1),.a(total_money[3:0]),.b(total_money[7:4]),.c(price[3:0]),.d(price[7:4]),.AN(AN),.seg(seg));
endmodule
