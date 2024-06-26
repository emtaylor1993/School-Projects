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
    Table t;

    /* Initialize the table */
    init_table(&t);

    /* Insert into the table */
    test_assert(key_count(&t) == 0, "insert", 0);
    test_assert(!insert(&t, "202", "DC"), "insert", 1);
    test_assert(key_count(&t) == 1, "insert", 2);

    /* Reset the table */
    reset_table(&t);
    test_assert(key_count(&t) == 0, "reset", 3);

    return 0;
}
