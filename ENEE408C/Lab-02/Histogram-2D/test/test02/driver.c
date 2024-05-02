#include <stdio.h>
#include "hist_2d.h"

/* Rows by Columns. */

#define W 2		/* Input W (Stride) length. */
#define H 4		/* Input H (Height) length. */
#define TW 2	/* Input TW (Tile Width) length. */
#define TH 1	/* Input TH (Tile Height) length. */
#define N 2		/* Input N (Number of Bins). */

int main(int argc, char **argv) {
	int pixels[H][W] ={{0}};
	int head[TW * TH] = {0};
	int bins[4] = {0};
	int output[2] = {0};
	FILE *fpixels_ptr = NULL;
	FILE *fbins_ptr = NULL;
	FILE *fout_ptr = NULL;
	int pixel_index1 = 0;
	int pixel_index2 = 0;
	int bin_index = 0;
	int output_index = 0;
	
	/* Check program usage. */
	if (argc != 4) {
		fprintf(stderr,"hist_2d.exe error: arg count.");
		return 1;
	}
	
	/* Open input and output files. */
	fpixels_ptr = fopen(argv[1], "r");
	fbins_ptr = fopen(argv[2], "r");
	fout_ptr = fopen(argv[3], "w");
	
	/* Read pixel data from input file. */
	for (pixel_index1 = 0; pixel_index1 < H; pixel_index1++){
		for (pixel_index2 = 0; pixel_index2 < W; pixel_index2++) {
			fscanf(fpixels_ptr, "%d", &pixels[pixel_index1][pixel_index2]);
		}
	}
	fclose(fpixels_ptr);
	
	head[0] = pixels[0][0];
	head[1] = pixels[0][1];


	/* Read bins from input file. */
	for (bin_index = 0; bin_index < 4; bin_index++) {
		fscanf(fbins_ptr, "%d", &bins[bin_index]);
	}
	fclose(fbins_ptr);

	/* Compute the 2D Histogram of the pixel data. */
	hist_2d(head, TW, TH, W, bins, N, output);

	/* Write the results to the output file. */
	for (output_index = 0; output_index < N; output_index++) {
		fprintf(fout_ptr, "[%d-%d]:\t%d\n", bins[2 * output_index], bins[2 * output_index + 1], output[output_index]);
	}
	fclose(fout_ptr);
	
	return 0;
}
