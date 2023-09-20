#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#pragma warning(disable : 4996)


typedef struct Node_t {
	int number[300];
	int size;
	struct Node_t* next;
}Node;

typedef struct {
	Node* head;
	int len;
}LinkedList;

LinkedList* InitList(void) {
	LinkedList* h;
	h = (LinkedList*)malloc(sizeof(LinkedList));
	h->head = NULL;
	h->len = 0;
	return h;
}

bool IsEmpty(LinkedList* h) {
	return h->len == 0;
}


void New(LinkedList* h,int first, int diff, int size) {
	if(size > 300){
		printf("error: size should be <= 300\n");
		exit(1);
	}

	Node* cur, * newNode;
	newNode = (Node*)malloc(sizeof(Node));
	newNode->size = size;
	newNode->next = NULL;
	for (int k = 0; k < size; k++) {
		newNode->number[k] = first + (k * diff);
	}

	if (h->head == NULL) {
		h->head = newNode;
		h->len++;
		return;
	}
	else{
	cur = h->head;
	while (cur->next != NULL) cur = cur->next;
	cur->next = newNode;
	h->len++;
	}
		
}

void Insert(LinkedList* h, int i, int j, int num) {
	Node* cur = h->head;
	for (int k = 0; k < i-1; k++) {
		cur = cur->next;
	}
	if (cur->size > 300)
		return;

	for (int k = cur->size - 1; k >= j; k--) {
		cur->number[k + 1] = cur->number[k];
	}
	cur->number[j] = num;
	cur->size++;
}

void Rseq(LinkedList* h, int i) {
	Node* pre; // 삭제할 노드의 선행자
	Node* cur; // 삭제할 노드

	cur = h->head;
	for (int k = 0; k < i - 1; k++) {
		cur = cur->next;
	}

	if(IsEmpty(h)) return;
	
	else if (i == 1) {
		h->head = cur->next;
		free(cur);
		h->len--;
	}
	else {
		pre = h->head;
		while (pre->next != cur)
			pre = pre->next;
		pre->next = cur->next;
		free(cur);
		h->len--;
	}
	
}

void Rrange(LinkedList* h, int i, int start, int end) {
	Node* cur = h->head;
	for (int k = 0; k < i - 1; k++) {
		cur = cur->next;
	}

	for (int k = start - 1; k < cur->size; k++) {
		cur->number[k] = cur->number[k + end - start + 1];
	}
	cur->size = cur->size - (end - start + 1);

	if(cur->size == 0)
		Rseq(h,i);
}

void Rone(LinkedList* h, int num) {
	Node* cur = h->head;
	
	for (int k = 0; k < h->len; k++) {
		int cons_size = cur->size;
		for (int s = 0; s < cons_size; s++) {
			if (cur->number[s] == num) {
				cur->number[s] = -1;
				cur->size--;
			}
		}
		cur = cur->next;
	}

	cur = h->head;
	for (int k = 0; k < h->len; k++) {
		int idx = 0;
		if (cur->size == 0) {
			Rseq(h, k + 1);
		}
		else {
			for (int s = 0; s < 300; s++) {
				if (idx == cur->size)
					break;

				if (cur->number[s] != -1) {
					cur->number[idx] = cur->number[s];
					idx++;
				}
			}
		}
		cur = cur->next;
	}

}


int Sum(LinkedList* h, int i) {
	Node* cur = h->head;
	int sum = 0;
	
	for (int k = 0; k < i; k++) {
		cur = cur->next;
	}
	

	for (int k = 0; k < cur->size; k++)
		sum += cur->number[k];

	return sum;
}


int main() {
	LinkedList* h = InitList();

	char cmd_type[11];

	while (1) {
		scanf("%s", cmd_type);

		if (!strcmp(cmd_type, "new")) {
			int first, diff, m;
			scanf("%d %d %d", &first, &diff, &m);
			New(h, first, diff, m);
		}
		else if (!strcmp(cmd_type, "insert")) {
			int i, j, num;
			scanf("%d %d %d", &i, &j, &num);
			Insert(h, i, j, num);
		}
		else if (!strcmp(cmd_type, "rseq")) {
			int i;
			scanf("%d", &i);
			Rseq(h, i);
		}
		else if (!strcmp(cmd_type, "rrange")) {
			int i, start, end;
			scanf("%d %d %d", &i, &start, &end);
			Rrange(h, i, start, end);
		}
		else if (!strcmp(cmd_type, "rone")) {
			int number;
			scanf("%d", &number);
			Rone(h, number);
		}
		else if (!strcmp(cmd_type, "sum")) {
			for (int i = 0; i < h->len; i++)
				printf("%d\n", Sum(h, i));
		}
		else if (!strcmp(cmd_type, "exit")) {
			break;
		}
	}

	
	return 0;
}

