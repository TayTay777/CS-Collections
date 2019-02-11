
#include <stdio.h>
#include <stdlib.h>

#include "common.h"
#include "Job.h"
#include "Node.h"
#include "List.h"




int main(int argc, char **argv)
{

List *list = createList();

Node *node = createNode(Test);

addAtRear(*list, *node);

if ( (list->head == node  && list->tail == node) && getSize(list) == 1 ){
printf("ok");
}
else printf("FAIL!!! TEST DOES NOT MATCH EXPECTED NODE VALUE(S)");
}
