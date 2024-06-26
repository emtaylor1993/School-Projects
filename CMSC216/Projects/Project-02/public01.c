#include "hashtable.h"
#include <stdio.h>
#include <string.h>

void test_assert(int test, const char* name, int idx)
{
    if (test) 
        printf("pass %s %d\n", name, idx);
    else printf("fail %s %d\n", name, idx);
}

int main(int argc, char* argv[])
{
    /* Test the hashing function */
    test_assert(hash_code("") == 0, "hash_code", 0);
    test_assert(hash_code("ice") == 451845518507L, "hash_code", 1);

    return 0;
}
