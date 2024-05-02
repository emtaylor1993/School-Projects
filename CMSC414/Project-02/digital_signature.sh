# Emmanuel Taylor
# CMSC414: Computer and Network Security
# Project 2: Crypto Lab - Public Key Cryptography and PKI

#!/bin/bash

# Generates a 1024-bit public/private RSA key pair.
openssl genrsa -out private.pem 1024
openssl rsa -in private.pem -out public.pem -outform PEM -pubout

# Generates a hash.
echo 'Hello World' > example.txt
openssl dgst -sha256 < example.txt > example.hash

# Signs the SHA256 hash of example.txt
openssl rsautl -sign -inkey private.pem -keyform PEM -in example.hash > example.sha256

# Verifies the digital signature of example.sha.256
openssl rsautl -verify -inkey public.pem -keyform pem -pubin -in example.sha256 > example.sha256.verified
echo '***********************************************************************'
echo 'Verification of signature of example.txt'
diff -s example.sha256.verified example.hash
echo '***********************************************************************'

# Slightly modifying example.txt by adding a character.
echo 'Hello Worlds' > example.modified.txt

# Generating a hash for the modified example.txt
openssl dgst -sha256 < example.modified.txt > example.modified.hash

echo 'Verification of signature of modified example.txt'
diff -s example.sha256.verified example.modified.hash
echo '***********************************************************************'