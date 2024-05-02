INC=/usr/local/ssl/include/
LIB=/usr/local/ssl/lib

all : enc

enc : key_finder.c
	gcc -I$(INC) -L$(LIB) -o enc key_finder.c -lcrypto

.PHONY : clean

clean :
	rm -rf enc