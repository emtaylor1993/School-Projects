/*
 * Emmanuel Taylor
 * CMSC414 - Computer and Network Security
 * Speed of RSA
 */

#include <openssl/pem.h>
#include <openssl/ssl.h>
#include <openssl/rsa.h>
#include <openssl/evp.h>
#include <openssl/bio.h>
#include <openssl/err.h>
#include <stdio.h>
#include <time.h>

/* Being safe with padding. */
int padding = RSA_PKCS1_PADDING;

/* In order to encrypt/decrypt with RSA, we need to prepare
 * an RSA structure. This function creates a structure with
 * a key buffer. */
RSA * createRSA(unsigned char * key, int public) {
  RSA *rsa = NULL;
  BIO *keybio;
  keybio = BIO_new_mem_buf(key, -1);

  if (keybio == NULL) {
    printf("Failed to create key BIO");
    return 0;
  }

  if (public) {
    rsa = PEM_read_bio_RSA_PUBKEY(keybio, &rsa, NULL, NULL);
  }

  else {
    rsa = PEM_read_bio_RSAPrivateKey(keybio, &rsa, NULL, NULL);
  }

  if (rsa == NULL) {
    printf("Failed to create RSA");
  }

  return rsa;
}

/* This function is used to encrypt the file with the public key. */
int public_encrypt(unsigned char * data, int data_len, unsigned char * key, unsigned char * encrypted) {
  RSA * rsa = createRSA(key, 1);
  int result = RSA_public_encrypt(data_len, data, encrypted, rsa, padding);
  return result;
}

/* This function is used to decrypt the file with the private key. */
int private_decrypt(unsigned char * enc_data, int data_len, unsigned char * key, unsigned char * decrypted) {
  RSA * rsa = createRSA(key, 0);
  int result = RSA_private_decrypt(data_len, enc_data, decrypted, rsa, padding);
  return result;
}

void printLastError(char *msg) {
  char * err = malloc(130);;
  ERR_load_crypto_strings();
  ERR_error_string(ERR_get_error(), err);
  printf("%s ERROR: %s\n", msg, err);
  free(err);
}

int main() {
  clock_t e_begin;
  clock_t e_end;
  clock_t d_begin;
  clock_t d_end;
  double e_time_spent;
  double d_time_spent;
  char plainText[1024/8] = "this is a test ";

  /* Public key extracted from private.pem */
  char publicKey[] = "-----BEGIN PUBLIC KEY-----\n"\
       "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCmmRBcaJO2vd/24ddU6msgx5qs\n" \
       "9YTWJKVZg+SgE8gv0jNFb5Tn2qBpO7A4NJlq+ESiwcRQXuXfKxkyLRk0d8qd47Zz\n"\
       "M6WKCc6gremh2n4p+/wEKHZEgI86undl3mGtmyqvcO2qvIfUy/CFnKeMtyz95KoO\n"\
       "OdZRQleY9fiz/TEIkQIDAQAB\n"\
       "-----END PUBLIC KEY-----\n";

  /* Private key located in the file private.pem */
  char privateKey[] = "-----BEGIN RSA PRIVATE KEY-----\n"\
       "MIICXAIBAAKBgQCmmRBcaJO2vd/24ddU6msgx5qs9YTWJKVZg+SgE8gv0jNFb5Tn\n"\
       "2qBpO7A4NJlq+ESiwcRQXuXfKxkyLRk0d8qd47ZzM6WKCc6gremh2n4p+/wEKHZE\n"\
       "gI86undl3mGtmyqvcO2qvIfUy/CFnKeMtyz95KoOOdZRQleY9fiz/TEIkQIDAQAB\n"\
       "AoGAOHLYplcQ5fSENKTlT3J2hg7cDArMzbpxBFm6V7scM4fns3lRXRYpED8XQJQh\n"\
       "/6rLptI88HaXMPzrdqLtTWfhkP3c4h99iDyRFtVEqrv6eN/3W9CoZEc1r5RrioO4\n"\
       "XyU3NLWrQicG1JG6IxpIdYhgZEqxBGIQ8fLMrppiRBAEZYECQQDcgr6d50VKEYOh\n"\
       "LX25rqmbTF3utlE+ll3fM4k4i7a5lPdojmiViZMaOgY5nJiga9cIfllVTPJBG3OR\n"\
       "By2FaAL5AkEAwWkPH/MqAH114jNqAYgVqmVoqeVWbgLWVIf2BNHZrEX9PT3lsO5O\n"\
       "UqobRO+EmXbslTuaeuvHCkn8r8yJdkgAWQJAKxn7PE4aQxINUpHbw1GaoVpZ+fD1\n"\
       "DHDDxH8EUWMtwjSV73/2fVQ4xqWU1eoAA0tQ6r4XpA64Q3WkLzLh+PONsQJAcJlD\n"\
       "Tux4BXUFDj20d1PMmTkUp+R2XvGT6f6FgeTR/vN4LRE+CbWTL5kM6yMuZVHRBkh+\n"\
       "9RUS+bB9RbOkS5I7cQJBAKjUeYUT2DcRBfyU/Dm0iGApqSr437vB+ouhnhvltlBK\n"\
       "1u1+Z2IhdecMcsiz4B1NPvhKFycfgIeFl5J6z9JTDfk=\n"\
       "-----END RSA PRIVATE KEY-----\n";

  unsigned char encrypted[4098] = {};
  unsigned char decrypted[4098] = {};
  int encrypted_length = 128;
  int decrypted_length = 15;
  int i = 0;
  int j = 0;
  int max = 100;
  
  /* This code block times how long RSA takes to encrypt a file 100 times. */
  e_begin = clock();
  e_time_spent = (double) e_begin / CLOCKS_PER_SEC;
  
  for (i = 0; i < max; i++) {
    int encrypted_length = public_encrypt(plainText, strlen(plainText), publicKey, encrypted);
    if (encrypted_length == -1) {
      printLastError("Public Encrypt failed ");
      exit(0);
    }
  }

  printf("Encrypted length = %d\n", encrypted_length);
  e_end = clock();  
  e_time_spent = (double)(e_end - e_begin) / CLOCKS_PER_SEC;
  printf("Encrypt time is %lf clocks per second.\n", e_time_spent);
  
  /* This code block times how long it takes RSA to decrypt a file 100 times. */
  d_begin = clock();
  d_time_spent = (double) d_begin / CLOCKS_PER_SEC;

  for (j = 0; j < max; j++) {
    int decrypted_length = private_decrypt(encrypted, encrypted_length, privateKey, decrypted);
    if (decrypted_length == -1) {
      printLastError("Private Decrypt failed ");
      exit(0);
    }
  }
  
  d_end = clock();
  d_time_spent = (double)(d_end - d_begin) / CLOCKS_PER_SEC;

  /* Prints the results in the units clocks per second. */
  printf("Decrypted text = %s\n", decrypted);
  printf("Decrypted length = %d\n", decrypted_length);
  printf("Decrypt time is %lf clocks per second.\n", d_time_spent);
}
			 
