CC = gcc
CFLAGS = -ansi -Wall -g -O0 -Wwrite-strings -Wshadow -fstack-protector-all 
LDFLAGS = -lpthread
PROGS = col fib fibMemo row

all: $(PROGS)

clean:
	@echo "Cleaning executables and .o files"
	@rm -f *.o $(PROGS) a.out
