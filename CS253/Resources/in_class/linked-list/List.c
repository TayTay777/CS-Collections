
#include <stdio.h>
#include <stdlib.h>
#include "List.h"

/*

    list.c
        Contains functions to manipulate a doubly-linked list.

*/


/* private methods */

static NodePtr reverse(NodePtr L);
static void print(NodePtr node);



ListPtr createList()
{
    ListPtr list = (ListPtr) malloc(sizeof(List));
    list->size = 0;
    list->head = NULL;
    list->tail = NULL;
    return list;
}

int getSize(ListPtr L)
{
    return L->size;
}

Boolean isEmpty(ListPtr L)
{
    if (L->size == 0)
        return TRUE;
    else
        return FALSE;
}

void addAtFront(ListPtr list, NodePtr node)
{
    if (list == NULL) return;
    if (node == NULL) return;
    list->size++;
    node->next = list->head;
    node->prev = NULL;
    if (list->head == NULL) {
        list->head = node;
        list->tail = node;
    } else {
        list->head->prev = node;
        list->head = node;
    }
}

void addAtRear(ListPtr list, NodePtr node)
{

// check for null list
if(list == NULL) {
return;
}

// is the node passed in null?
if(node == NULL){
return;
}

//if the list is empty the new list will be both head and tail
if (isEmpty(list)){
list->head = node;
list->tail = node;
}
list->size++;
else {
list->tail->next = node;
node->prev = list->tail;
list->tail = node;
}

}




NodePtr removeFront(ListPtr list)
{
if(list == NULL){
return;
} 

if (isEmpty(list)){
return NULL;
}

NodePtr returnNode = list->head;

if (list->head == list->tail){
list->head = NULL;
list->tail = NULL;
} 

else if (list->head != list->tail){
list->head->next = list->head;
list->head->prev = NULL;
returnNode->next = NULL;
}
list->size--;
return returnNode;
}




NodePtr removeRear(ListPtr list)
{
    return NULL;
}

NodePtr removeNode(ListPtr list, NodePtr node)
{
    return NULL;
}

NodePtr search(ListPtr list, int key)
{
    return NULL;
}

void reverseList(ListPtr L)
{
    L->tail = L->head;
    L->head  = reverse (L->head);
}

static NodePtr reverse(NodePtr L)
{
    /* finish this function */
    return NULL;
}

void printList(ListPtr L)
{
    if (L) print(L->head);
}

static void print(NodePtr node)
{
    int count = 0;
    char *buf;

    while (node) {
        buf = toString(node->data);
        printf(" %s -->", buf);
        free(buf);
        node = node->next;
        count++;
        if ((count % 6) == 0)
            printf("\n");
    }
    printf(" NULL \n");
}


void freeList(ListPtr L)
{
}


