# Emmanuel Taylor
# CMSC414: Computer and Network Security
# Project 2: Crypto Lab - Public Key Cryptography and PKI
# October 8, 2014

# Task 5: Compare the speed of RSA Encryption with that of 
# AES Encryption.

#!/bin/bash

# Generates a 1024-bit public/private RSA key pair.
openssl genrsa -out private.pem 1024
openssl rsa -in private.pem -out public.pem -outform PEM -pubout

# Number of test iterations.
MAX=1000

# Encrypting message.txt with RSA.
echo "Encrypt message.txt using RSA $MAX times."
time for ((i = 0; i < MAX; i++))
do
openssl rsautl -encrypt -inkey public.pem -pubin -in message.txt -out message_enc.txt
done

# Decrypting message_enc.txt with RSA.
echo "Decrypt message_enc.txt using RSA $MAX times."
time for ((i = 0; i < MAX; i++))
do
openssl rsautl -decrypt -inkey private.pem -in message_enc.txt -out message_dec.txt
done

# Encrypting message.txt with AES.
echo "Encrypt message.txt using AES $MAX times."
time for ((i = 0; i < MAX; i++))
do
openssl enc -aes-128-cbc -e -in message.txt -out message_enc.txt -K 00112233445566778899aabbccddeeff -iv 0102030405060708
done

# Decrypting message_enc.txt with AES.
echo "Decrypt message_enc.txt using AES $MAX times."
time for ((i = 0; i < MAX; i++))
do
openssl enc -aes-128-cbc -d -in message_enc.txt -out message.txt -K 00112233445566778899aabbccddeeff -iv 0102030405060708
done