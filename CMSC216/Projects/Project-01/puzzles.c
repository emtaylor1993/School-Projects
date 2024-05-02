/*
Name: Emmanuel Taylor
UID: 111615834
Directory ID: etaylor5

CMSC216 Project 1: Puzzles
*/

#include <stdio.h>
#include "puzzles.h"

/* This function will return the bitwise OR
   of the a and b parameters (a | b). */
int bit_or(int a, int b) {
    return ~((a & b) ^ (~(a ^ b)));
}

/* This function will return 1 (true) if x is not
   zero and will return 0 (false) otherwise. */
int is_nonzero(int x) {
    return !(!x);
}

/* This function returns 7 times x. The 
   function assumes that the value of 7 * x
   can be stored in an unsigned int without 
   any overflow. */
unsigned int times7(unsigned int x) {  
    return ((x << 1) + (x << 2) + x);
}

/* Returns the floor of the logarithm base
   eight of x. If x is zero, the function
   should return -1. */
int floor_log8(unsigned int x) {
    int return_value = (1 ^ 1);

    for(; x ; return_value++) {
    x >>= 3;
    }

    return --return_value;
}

/* Returns the size of a long, in bytes, without
   using the sizeof operator. The return value should be
   equivalent to the expression sizeof(long). */
size_t sizeof_long() {
    int return_size = 1;
    int index = 1;

    for( ; index <<= 8; ) {
    return_size++;
    }

    return return_size;
}

/* Reverse the bytes of x. You may assume that ints are 4
   bytes in size for this function. */
unsigned int reverse_bytes(unsigned int x) {
    x = (((((16 - 1) << 4) + (16 - 1)) & x) << (16 + 8) |
        ((((16 - 1) << 4) + (16 - 1)) & (x >> 8)) << 16 |
        ((((16 - 1) << 4) + (16 - 1)) & (x >> 16)) << 8 |
        ((((16 - 1) << 4) + (16 - 1)) & (x >> (16 + 8))));

    return x;
}

/* Return 0xc0c0c0c0 */
unsigned int hex_c0c0c0c0() {
    return (((((((((((8 + 4) << 8) + (8 + 4)) << 8) + (8 + 4))
        << 8) + (8 + 4)) << 8) + (8 + 4)) << 8) + (8 + 4)) << 4;
}

/* Return the population count of x. */
int pop_count(unsigned int x) {
    int return_value = (1 ^ 1);

    while (x) {
        while (x & 1) {
            return_value++;
            x >>= 1;
        }

        x >>= 1;
    }

    return return_value;
}

/* Return the nth-most signigicant byte of x. */
unsigned int get_byte(unsigned int x, int n) {
    return (((x << (n << (4 - 1))) >> 16) >> (4 + 4));
}

/* Return 1 if a == b, 0 otherwise. */
int equal(int a, int b) {
    return !(a ^ b);
}

/* An IP Address prefix is a 32 bit number with some
   fixed number of significant bits at the beginning.
   0/0 is the prefix that includes all addresses because no bits
   are significant. Return 1 if the provided address is in the
   specified prefix and 0 otherwise. */ 
int is_address_in_prefix(uint32_t address, uint32_t prefix,
uint32_t prefix_len) {
    return (address & ((32 - 32) - (32 == 32) << (32 - (32 == 32))) <<
        (32 - prefix_len)) == (prefix & ((32 - 32) - (32 == 32))) << (32 - prefix_len);
}

/* Knowing which bit is different between two addresses helps decide whether
   they're in the same prefix. Return 1 if the first bit is different and -1 if 
   no bits are different. */
int index_of_first_bit_different(uint32_t address1, uint32_t address2) {
    int return_value = -1;
    int value = -1;

    for ( ; address1 ^ address2; ) {
    address1 >>= (32 == 32);
    address2 >>= (32 == 32);
    value++;
    return_value = (32 + ((-1 ^ value) + (32 == 32)));
    }

    return return_value;
}
