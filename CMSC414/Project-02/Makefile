INC=/usr/local/ssl/include/
LIB=/usr/local/ssl/lib/

all:
	g++ -I$(INC) -L$(LIB) cli.cpp -o cli -lssl -lcrypto -ldl -fpermissive
	g++ -I$(INC) -L$(LIB) serv.cpp -o serv -lssl -lcrypto -ldl -fpermissive
	gcc -I$(INC) -L$(LIB) rsa.c -o rsa -lssl -lcrypto -ldl
	gcc -I$(INC) -L$(LIB) aes.c -o aes -lssl -lcrypto -ldl

clean:
	rm -rf *~ cli serv rsa aes
