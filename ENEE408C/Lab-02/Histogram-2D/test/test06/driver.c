#include <stdio.h>
#include "hist_2d.h"

/* Rows by Columns. */

#define W 4		/* Input W (Stride) length. */
#define H 3		/* Input H (Height) length. */
#define TW 2	/* Input TW (Tile Width) length. */
#define TH 2	/* Input TH (Tile Height) length. */
#define N 4		/* Input N (Number of Bins). */

int main(int argc, char **argv) {
	int pixels[H][W] ={{0}};
	int head[TW * TH] = {0};
	int bins[8] = {0};
	int output[4] = {0};
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
	for (pixel_index1 = 0; pixel_index1 < 3; pixel_index1++){
		for (pixel_index2 = 0; pixel_index2 < 4; pixel_index2++) {
			fscanf(fpixels_ptr, "%d", &pixels[pixel_index1][pixel_index2]);
		}
	}
	fclose(fpixels_ptr);
	
	head[0] = pixels[1][1];
	head[1] = pixels[1][2];
	head[2] = pixels[2][1];
	head[3] = pixels[2][2];

	/* Read bins from input file. */
	for (bin_index = 0; bin_index < 8; bin_index++) {
		fscanf(fbins_ptr, "%d", &bins[bin_index]);
	}
	fclose(fbins_ptr);

	/* Compute the 2D Histogram of the pixel data. */
	hist_2d(head, TW, TH, W, bins, 4, output);

	/* Write the results to the output file. */
	for (output_index = 0; output_index < N; output_index++){
		if (output_index == 0) {
			fprintf(fout_ptr, "[%d-%d]:\t\t%d\n", bins[2 * output_index], bins[2 * output_index + 1], output[output_index]);
		} else {
			fprintf(fout_ptr, "[%d-%d]:\t%d\n", bins[2 * output_index], bins[2 * output_index + 1], output[output_index]);
		}
	}
	fclose(fout_ptr);
	
	return 0;
}
