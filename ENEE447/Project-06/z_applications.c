#include "hype.h"
#include "syscall.h"

unsigned char init_core1[20] = "Core 1: Started!";
unsigned char device_led[50] = "LED";
unsigned char device_monitor[50] = "Monitor";
unsigned char device_sdcard[50] = "SD Card";
unsigned char device_clock[50] = "Clock";
unsigned char device_null[50] = "Null";
unsigned char newprocess[50] = "New Process";
unsigned char newthread[50] = "New Thread";

void user_code() {
	char *args = {};
	oldwait(1);
	flash_led(1, RED, 15);
	print_text(init_core1);
	flash_led(1, RED|GRN, 15);
	
	oldwait(10);
	print_text(device_led);
	read(DEVICE_LED, DEVCALL_READ, 1, args, 1);
	write(DEVICE_LED, DEVCALL_WRITE, 1, args, 1);
	read(DEVICE_LED, DEVCALL_NULL, 2, args, 1);
	write(DEVICE_LED, DEVCALL_NULL, 2, args, 1);
	
	print_text(device_monitor);
	read(DEVICE_MONITOR, DEVCALL_READ, 1, args, 1);
	write(DEVICE_MONITOR, DEVCALL_WRITE, 1, args, 1);
	read(DEVICE_MONITOR, DEVCALL_NULL, 2, args, 1);
	write(DEVICE_MONITOR, DEVCALL_NULL, 2, args, 1);
	
	print_text(device_sdcard);
	read(DEVICE_SDCARD, DEVCALL_READ, 1, args, 1);
	write(DEVICE_SDCARD, DEVCALL_WRITE, 1, args, 1);
	read(DEVICE_SDCARD, DEVCALL_NULL, 2, args, 1);
	write(DEVICE_SDCARD, DEVCALL_NULL, 2, args, 1);
	
	print_text(device_clock);
	read(DEVICE_CLOCKS, DEVCALL_READ, 1, args, 1);
	write(DEVICE_CLOCKS, DEVCALL_WRITE, 1, args, 1);
	read(DEVICE_CLOCKS, DEVCALL_NULL, 2, args, 1);
	write(DEVICE_CLOCKS, DEVCALL_NULL, 2, args, 1);
	
	print_text(newthread);
	new_thread(&print_text);
	
	print_text(new_process);
	new_process("");
}