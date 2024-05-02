#include <stdio.h>
#include "hist.h"

void hist(int *data, int n, int *bins, int m, int *out) {
	int i = 0;
	int output[4] = {0, 0, 0, 0};

    for (i = 0; i < n; i++) {
		if (data[i] >= 0 && data[i] <= 63) {
			output[0] += 1;
 		} else if (data[i] >= 64 && data[i] <= 127) {
			output[1] += 1;
		} else if (data[i] >= 128 && data[i] <= 191) {
			output[2] += 1;
		} else if (data[i] >= 192 && data[i] <= 255) {
			output[3] += 1;
		} else {
			printf("Observation is out of range. Try again.\n");			
		}
	}
	out[0] = output[0];
	out[1] = output[1];
	out[2] = output[2];
	out[3] = output[3];
}
