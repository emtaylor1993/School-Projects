CC = gcc

# Because we are not including <sys/wait.h> we can use the -pedantic-errors flag
CFLAGS= -ansi -Wall -g -O0 -Wwrite-strings -Wshadow -fstack-protector-all -pedantic-errors
PROGS = dup2Ex1 dup2Ex2 pipe1 EngToSpa SpaToFre EngToFre

all: $(PROGS)

clean: 
	rm -f a.out *.o $(PROGS)