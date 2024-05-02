/* Emmanuel Taylor
 * CMSC414 - Computer and Network Security
 * September 26, 2014
 * Project 1: Crypto Lab - Secret Key Encryption
 */

/*
 * The purpose of this project was to become familiar
 * with the various modes of AES-128 Encryption. For 
 * this particular project, we learned how to use AES-128
 * -CBC to find the correct key out of a file containing 
 * a list of potential keys.
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <openssl/evp.h>

int main(void) {
  unsigned char outbuf[1024];
  unsigned char iv[] = "\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00";
  unsigned char key[] = "\x20\x20\x20\x20\x20\x20\x20\x20\x20\x20\x20\x20\x20\x20\x20\x20";
  char ptext[] = "This is a top secret.";
  char ctext[] = "\x8d\x20\xe5\x05\x6a\x8d\x24\xd0\x46\x2c\xe7\x4e\x49\x04\xc1\xb5\x13\xe1\x0d\x1d\xf4\xa2\xef\x2a\xd4\x54\x0f\xae\x1c\xa0\xaa\xf9";
  int olen, tlen;
  int i = 0;
  FILE *fp;

  fp = fopen("words.txt", "rb");

  if (!fp) {
    printf("Error: Unable to open file 'words.txt'\n");
    return 1;
  }

  EVP_CIPHER_CTX ctx;
  EVP_CIPHER_CTX_init(&ctx);

  /* Within this while construct, pad each potential key to 16
   * characters to be accepted by the AES-128-CBC mode. */
  while(fscanf(fp, "%s", key) != EOF) {
    for(i = strlen(key); i < 16; i++) {
      key[i] = 0x20;
    }

    EVP_EncryptInit_ex(&ctx, EVP_aes_128_cbc(), NULL, key, iv);

    if (!EVP_EncryptUpdate(&ctx, outbuf, &olen, ptext, strlen(ptext))) {
      return 2;
    }

    if (!EVP_EncryptFinal(&ctx, outbuf + olen, &tlen)) {
      return 3;
    }

    olen += tlen;

    if (strcmp(outbuf, ctext) == 0) {
      printf("The key used to encrypt is %s.\n", key);
    }

    memset(outbuf, 0x00, sizeof(outbuf));
    memset(key, 0x20, sizeof(key));
    memset(iv, 0x00, sizeof(iv));
  }

  EVP_CIPHER_CTX_cleanup(&ctx);
  fclose(fp);
  return 0;
}
