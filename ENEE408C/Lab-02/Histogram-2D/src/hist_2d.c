#include <stdio.h>
#include "hist_2d.h"

void hist_2d(int *head, int w, int h, int stride, int *bins, int m, int *out){
	/* int output[m]; */
	/* int output_index = 0; */
	int bin_index = 0;
	int head_index = 0;
	
	for (bin_index = 0; bin_index < m; bin_index++) {
		for (head_index = 0; head_index < m; head_index ++) {
			if (head[head_index] >= bins[2 * bin_index] && head[head_index] <= bins[2 * bin_index + 1]) {
				out[bin_index]++;
			}
		}
	}
	/* 
	for (output_index = 0; output_index < m; output_index++) {
		out[output_index] = output[output_index];
	}
	*/
}
