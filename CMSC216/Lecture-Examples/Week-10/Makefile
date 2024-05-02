CC = gcc
CFLAGS = -ansi -pedantic-errors -Wall -Werror
LDFLAGS = -lpthread
PROGS = threadsBasics threadsRetRandomValue threadsRetSqrValue threadsSeveral \
	threadsNoSem threadsSem pthreadsSync pthreadsSync2 race raceFixed

all: $(PROGS)

clean:
	@echo "Cleaning executables and .o files"
	@rm -f *.o $(PROGS) a.out
