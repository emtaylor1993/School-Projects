CC = gcc

# NOTICE -pedantic-errors not included
# CFLAGS does not include -pedantic-errors as a file that is
# included by <sys/wait.h> does not compile with this flag

CFLAGS= -ansi -Wall -g -O0 -Wwrite-strings -Wshadow -fstack-protector-all
PROGS = execve1 execle2 execlp3 execvp4 wait1 wait2 wait3 wait4ReapNonDeterministic wait5ReapDeterministic \
	reapingForShell 

all: $(PROGS)

clean: 
	rm -f a.out *.o $(PROGS)
