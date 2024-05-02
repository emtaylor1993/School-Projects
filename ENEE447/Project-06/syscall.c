#include "hype.h"
#include "syscall.h"

unsigned char read_message[50] = "We are in READ.\n";
unsigned char write_message[50] = "We are in WRITE.\n";
unsigned char proc_message[50] = "Started a NEW PROCESS.\n";
unsigned char thread_message[50] = "Started a NEW THREAD.\n";
unsigned char id[20] = "ID: \n";
unsigned char entry_message[20] = "Entry: \n";
unsigned char syscall_message[100] = "We are handling the system call.\n";
unsigned char null_message[20] = "Null.\n";

unsigned int dev_type, function_type, dev_id;

// System Calls
static void sys_read(char *buf, unsigned int len) {
	print_text(read_message);
}

static void sys_write(char *buf, unsigned int len) {
	print_text(write_message);
}

static void sys_new_proc(char *executable) {
	print_text(proc_message);
}

static void sys_new_thread(int entrypoint) {
	print_text(entry_message);
	printhex(entrypoint);
	print_text(thread_message);
}

// User Functions
void null(void) {
	print_text(null_message);
}

void read(unsigned int device_type, unsigned int func, unsigned int id, char *buf, unsigned int len) {
	syscall(function_type, device_type, id, buf, len);
}

void write(unsigned int device_type, unsigned int func, unsigned int id, char *buf, unsigned int len) {
	syscall(function_type, device_type, id, buf, len);
}

void new_proc(char *executable) {
	syscall(SYSCALL_NEWPROC, DEVICE_NULL, -1, executable, 0);
}

void new_thread(pfv_t entrypoint) {
	syscall(SYSCALL_NEWTHREAD, DEVICE_NULL, -1, "", 0);
}

// System Call Wrapper
void syscall(unsigned int function, unsigned int type, unsigned int device_id, char *args, unsigned int arg_size) {
	dev_type = type;
	function_type = function;
	dev_id = device_id;
	asm("svc #0");
}

void syscall_handler(char *args, unsigned int arg_size) {
	unsigned int device = dev_type;
	unsigned int function = function_type;
	unsigned int device_id = dev_id;
	
	if (device == DEVICE_NULL) {
		if (function == SYSCALL_NULL) {
			null();
			blink_led(GRN);
		} else if (function == SYSCALL_NEWPROC) {
			sys_new_proc(args);
			blink_led(GRN);
		} else if (function == SYSCALL_NEWTHREAD) {
			sys_new_thread(0x1234);
			blink_led(GRN);
		} else {
			blink_led(RED);
		}
	} else if ((device == DEVICE_LED) | (device == DEVICE_MONITOR) | (device == DEVICE_SDCARD) | (device == DEVICE_CLOCKS)) {
		print_text(id);
		printhex(device_id);
		
		if (function == DEVCALL_NULL) {
			null();
			blink_led(GRN);
		} else if (function == DEVCALL_READ) {
			sys_read(args, arg_size);
			blink_led(GRN);
		} else if (function == DEVCALL_WRITE) {
			sys_write(args, arg_size);
			blink_led(GRN);
		} else {
			blink_red(RED);
		}
	} else {
		blink_led(RED);
	}
}