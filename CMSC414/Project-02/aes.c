#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <openssl/aes.h>
#include <openssl/rand.h>
#include <time.h>

int main(int argc, char **argv) {
  int keylength = 128;

  /* Generates a 128 bit key. */
  unsigned char aes_key[keylength/8];
  memset(aes_key, 0, keylength/8);
  if (!RAND_bytes(aes_key, keylength/8))
    exit(-1);

  /* Normalizes the input to have a length of 16. */
  size_t inputslength = 16;
  unsigned char aes_input[] = "this is a test ";

  unsigned char iv_enc[AES_BLOCK_SIZE], iv_dec[AES_BLOCK_SIZE];
  RAND_bytes(iv_enc, AES_BLOCK_SIZE);
  memcpy(iv_dec, iv_enc, AES_BLOCK_SIZE);

  const size_t encslength = ((inputslength + AES_BLOCK_SIZE) / AES_BLOCK_SIZE) * AES_BLOCK_SIZE;
  unsigned char enc_out[encslength];
  unsigned char dec_out[inputslength];
  memset(enc_out, 0, sizeof(enc_out));
  memset(dec_out, 0, sizeof(dec_out));

  AES_KEY enc_key, dec_key;

  clock_t e_begin, e_end;
  clock_t d_begin, d_end;
  double e_time_spent, d_time_spent;
  int i = 0;
  int j = 0;
  int max = 100000;

  /* Times how long it takes AES to encrypt a file 100000 times. */
  e_begin = clock();
  e_time_spent = (double)e_begin / CLOCKS_PER_SEC;
  for (i = 0; i < max; i++) {
    AES_set_encrypt_key(aes_key, keylength, &enc_key);
    AES_cbc_encrypt(aes_input, enc_out, inputslength, &enc_key, iv_enc, AES_ENCRYPT);
  }
  e_end = clock();
  e_time_spent = (double)(e_end - e_begin) / CLOCKS_PER_SEC;

  /* Times how long it takes AES to decrypt a file 100000 times. */
  d_begin = clock();
  d_time_spent = (double)d_begin / CLOCKS_PER_SEC;
  for (j = 0; j < max; j++) {
    AES_set_decrypt_key(aes_key, keylength, &dec_key);
    AES_cbc_encrypt(enc_out, dec_out, encslength, &dec_key, iv_dec, AES_DECRYPT);
  }
  d_end = clock();
  d_time_spent = (double)(d_end - d_begin) / CLOCKS_PER_SEC;

  /* Prints the results in the units clocks per second. */
  printf("AES Input: %s\n", aes_input);
  printf("Encryption Time: %lf clocks per second.\n", e_time_spent);
  printf("Decryption Time: %lf clocks per second.\n", d_time_spent);

  return 0;
}
