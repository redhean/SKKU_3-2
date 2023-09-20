#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
# pragma warning(disable:4996)


#define MAX_QUEUE 100000  // N의 크기가 100,000 보다 작거나 같다

typedef struct {
	int front, rear;
	int items[MAX_QUEUE];
}Queue;

Queue* InitQueue() {
	Queue* Q;
	Q = (Queue*)malloc(sizeof(Queue));
	Q->front = -1;
	Q->rear = -1;
	return Q;
}

bool IsEmpty(Queue* Q) {
	if (Q->front == Q->rear)
		return true;
	else false;
}

bool IsFull(Queue* Q) {
	if (Q->rear != MAX_QUEUE - 1)
		return false;
	else true;
}

void EnQueue(Queue* Q, int item) {
	if (IsFull(Q))
		printf("Error! Queue is full!\n");
	else {
		Q->rear++;
		Q->items[Q->rear] = item;
	}
}

int DeQueue(Queue* Q) {
	if (IsEmpty(Q))
		printf("Error! Queue is empty!\n");
	else {
		Q->front++;
		return Q->items[Q->front];
	}
}


// 입력 받은 정수를 정렬하기 위한 qsort함수에 사용할 compare함수
int compare(const void* a, const void* b) {
	int num1 = *(int*)a;
	int num2 = *(int*)b;

	if (num1 > num2)
		return 1;
	else if (num1 < num2)
		return -1;
	else
		return 0;
}


int main() {
	int result[MAX_QUEUE];	// 출력 값들을 저장할 배열 선언
	Queue* Q = InitQueue();
	int N;
	scanf("%d", &N); // 정수 N을 입력 받음

	for (int i = 0; i < N; i++) {
		// i는 정수의 개수가 아닌 인덱스임을 유의
		
		int num;
		scanf("%d", &num);
		if(num < -10000 || num > 10000){
			printf("Error! -10000 <= x <= 10000\n");
			break;
		}else
			EnQueue(Q,num);
		
		qsort(Q->items, i + 1, sizeof(Q->items[0]), compare); // 정수를 입력받고 현 상황에서 정렬해준다.

		if (i == 0)						// 정수가 한개 뿐이면 자기 자신을 출력
			result[0] = Q->items[0];
		else							// 아니면 중간 값 출력
			result[i] = Q->items[i / 2];	// 짝수개일 경우 두 수 중에서 작은 수를 출력하기 때문에
											// 홀수 짝수 상관없이 i / 2로 가능
	}

	for (int i = 0; i < N; i++) {
		printf("%d ", result[i]);
	}
	printf("\n");
	return 0;
}

