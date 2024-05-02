#include <stdio.h>
#include "hist.h"

#define M 10	/* input vector length */

int main(int argc, char **argv) {
	int data[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	int output[4] = {0};
	int bins[8] = {0, 63, 64, 127, 128, 191, 192, 255}; 
	FILE *fout_ptr = NULL;

	/* Check program usage. */
	if (argc != 2) {
		fprintf(stderr, "hist.exe error: arg count");
		return 1;
	}

	/* Open input and output files. */
	fout_ptr = fopen(argv[1], "w");
	
	/* Compute the histogram of data observations. */
	hist(data, M, bins, 4, output);

	/* Write the result to the output file. */
	fprintf(fout_ptr, "{%d, %d, %d, %d}", output[0], output[1], output[2], output[3]);
	fprintf(fout_ptr, "\n");
	fclose(fout_ptr);

	return 0;
}

