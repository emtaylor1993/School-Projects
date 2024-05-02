CC = gcc
CFLAGS1 = -g -ldl
CFLAGS2 = -fno-stack-protector -z noexecstack
CFLAGS3 = -z noexecstack

exploit:
	@$(CC) $(CFLAGS1) -o exploit exploit.c

retlib:
	@$(CC) $(CFLAGS1) $(CFLAGS2) -o retlib retlib.c

relibc:
	@$(CC) $(CFLAGS1) $(CFLAGS3) -o relibc retlib.c

myshell:
	@$(CC) $(CFLAGS1) -o myshell myshell.c

sp:
	@$(CC) $(CFLAGS1) -o sp sp.c

all:
	@$(CC) $(CFLAGS1) -o exploit exploit.c
	@$(CC) $(CFLAGS1) $(CFLAGS2) -o retlib retlib.c
	@$(CC) $(CFLAGS1) $(CFLAGS3) -o relibc retlib.c

clean:
	@rm -rf exploit
	@rm -rf retlib
	@rm -rf relibc
	@rm -rf *.c~
	@rm -rf myshell
	@rm -rf sp
	@rm -rf Makefile~
	@rm -rf badfile