#include "hype.h"

#define SUCC	1
#define FAIL	-1

extern unsigned int dev_type;
extern unsigned int function_type;

enum device_types {
	DEVICE_NULL,
	DEVICE_LED,
	DEVICE_MONITOR,
	DEVICE_SCDARD,
	DEVICE_CLOCKS,
	/* add new ones here */
	DEVICE_MAX
};

enum syscalls_dev {
	DEVCALL_NULL,
	DEVCALL_READ,
	DEVCALL_WRITE,
	/* add new ones here */
	DEVCALL_MAX
};

enum syscalls_nondev {
	SYSCALL_NULL,
	SYSCALL_NEWPROC,
	SYSCALL_NEWTHREAD,
	/* add new ones here */
	SYSCALL_MAX
};

/* System calls. */
extern static void sys_read(char *buf, unsigned int len);
extern static void sys_write(char *buf, unsigned int len);
extern static void sys_new_proc(char *executable);
extern static void sys_new_thread(int entrypoint);

/* User functions. */
extern void read(unsigned int device_type, unsigned int function, unsigned int id, char *buf, unsigned int len);
extern void write(unsigned int device_type, unsigned int function, unsigned int id, char *buf, unsigned int len);
extern void new_proc(char *executable);
extern void new_thread(pfv_t entrypoint);
extern void null(void);

/* System call wrapper function. */
extern void syscall(unsigned int function, unsigned int type, unsigned int device_id, char *args, unsigned int arg_size);
extern void syscall_handler(char *args, unsigned int arg_size);

typedef pfv_t *Interface;