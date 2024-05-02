# Java Sockets - UDP Server and Client

**The server runs as localhost and listens on port 11111. The server does the following:**
- The server waits for a client request. It has two fields: Name of a web server and a timer value in seconds.
- When the server gets the client request, it starts a separate handler for the client. The server does all the client-related processing and communication using the handler. The main thread in the server only listens for client requests.
- The server starts a timer set to the timer value.
- The server sends a GET request to the web server over HTTPS using HttpURLConnection.
- The server stores all of the data received from the web server in memory.
- After receiving all of the data from the web server, the server sends packets with the web server's data to the client. The paylload in each packet from the server to the client carries 1000 bytes of W's data except for the payload in the last packet that carries the remaining bytes of the web server's data.
- If the server gets the ACK from C before the timer expires, the server prints "DONE". If the timer expires before recieving the ACK from the client, the server retransmits all of the data to the client and prints "RESENT". The data is retransmitted only once and there is only one ACK from the client.

**The client communicates over UDP with the localhost server using port 11111. The client does the following:**
- Asks the user to enter a web server name.
- Asks the user to enter a timer value in seconds.
- The client starts a timer set to the timer value.
- The client sends a packet to the server with two fields containing the web server name and timer value.
- The client waits for the data from the server. The packets may be from the first transmission or the retransmission.
- If the client receives all of the data packets from the server before the timer expires, it puts them in order using the packet numbers, sends exactly one ACK to the server and prints the contents in the messages followed by the message "OK".
- If all the packets are not received before the timer expires, the client prints the message "FAIL" and quits.
