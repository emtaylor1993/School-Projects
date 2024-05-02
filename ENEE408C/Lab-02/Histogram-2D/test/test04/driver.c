#include <stdio.h>
#include "hist_2d.h"

/* Rows by Columns. */

#define W 4		/* Input W (Stride) length. */
#define H 4		/* Input H (Height) length. */
#define TW 2	/* Input TW (Tile Width) length. */
#define TH 1	/* Input TH (Tile Height) length. */
#define N 2		/* Input N (Number of Bins). */

int main(int argc, char **argv) {
	int pixels[H][W] ={{1, 2, 3, 4}, {4, 3, 2, 1}, {2, 4, 1, 3}, {4, 1, 3, 2}};  
	int head[TW * TH] = {0};
	int bins[4] = {1, 3, 4, 7};
	int output[2] = {0};
	FILE *fout_ptr = NULL;
	int output_index = 0;
	
	/* Check program usage. */
	if (argc != 2) {
		fprintf(stderr,"hist_2d.exe error: arg count.");
		return 1;
	}
	
	/* Open input and output files. */
	fout_ptr = fopen(argv[1], "w");
	
	head[0] = pixels[1][0];
	head[1] = pixels[1][1];

	/* Compute the 2D Histogram of the pixel data. */
	hist_2d(head, TW, TH, W, bins, N, output);

	/* Write the results to the output file. */
	for (output_index = 0; output_index < N; output_index++) {
		fprintf(fout_ptr, "[%d-%d]:\t%d\n", bins[2 * output_index], bins[2 * output_index + 1], output[output_index]);
	}
	fclose(fout_ptr);
	
	return 0;
}
