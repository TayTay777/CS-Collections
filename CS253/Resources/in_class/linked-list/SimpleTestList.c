
#include <stdio.h>
#include <stdlib.h>

#include "common.h"
#include "Job.h"
#include "Node.h"
#include "List.h"


int main(int argc, char **argv)
{
    int i;
    int n;
    NodePtr node;
    NodePtr testHead;
    JobPtr job;
    ListPtr list;

    if (argc != 2) {
        fprintf(stderr, "Usage: %s <list size> \n",argv[0]);
        exit(1);
    }

    n = atoi(argv[1]);
    list = createList();
    for (i=0; i<n; i++) {
    job = createJob(i, "cmd args");
    node = createNode(job);
    addAtFront(list, node);

    //add at rear test
    addAtRear(*list, *node);

    if (list->tail == node){
    printf("ok");
    }
    else { printf("FAIL!!! TEST DOES NOT MATCH EXPECTED NODE VALUE(S)"); }

    //removeFront test
    testHead = list->head;
    removeFront(*List);
    
    if (list->head == testHead){
    printf("FAIL!!! TEST DOES NOT MATCH EXPECTED NODE VALUE(S)");
    }

    if (list->head == testHead->next){
    printf("ok");
    }
    

    printList(list);

    reverseList(list);

    printList(list);

    reverseList(list);

    printList(list);


    exit(0);
//main brackett
}

