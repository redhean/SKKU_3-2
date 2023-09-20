#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
# pragma warning(disable:4996)

#define STACK_SIZE 1000     // 최대 입력 길이 < 1000

char stack[STACK_SIZE];
int top = -1;

bool IsEmpty() {
	if (top == -1)
		return true;
	else
		return false;
}

bool IsFull() {
	if (top == STACK_SIZE - 1)
		return true;
	else
		return false;
}

void push(char item) {
	if (IsFull())
		printf("Error! Stack is full!");
	else stack[++top] = item;
}

char pop() {
	if (IsEmpty())
		printf("Error! Stack is empty!");
	else stack[top--];
}

int main() {
	char input[1000];  // 문자열을 입력 받을 배열 
	int i = 0;
	int temp_height = 0;
	int max_height = 0;

	scanf("%s", input);

	while (input[i]) {  

		if (input[0] == '\\')  // '/'이 아닌 '\'으로 시작한 경우 처리
			break;

		if (input[i] == '/') { // '/'이 나오면 스택에 push한다.
			if (!IsFull()) {
				push('/');
				temp_height++; // push를 하면 temp_height변수를 1 증가시킨다.
			}
			else {
				printf("용량을 초과하였습니다!\n");  // 문자열이 용량을 초과하였을 경우 처리
				break;
			}
			
		}
		else if (input[i] == '\\') { // '\'이 나오면 스택에서 pop한다.
			if (!IsEmpty()) {
				pop();
				temp_height--;  // pop을 하면 temp_height변수를 1 감소 시킨다.
			}
			else {          // 스택이 비어 있는데 pop을 해야하는 경우로 산이 만들어 지지 않음(temp_height가 음수가 됨)
				push('\\'); // 0을 출력하게 하기 위한 조치
				break;
			}
		}
		else continue;

		if (max_height < temp_height)  // 제일 높은 산의 높이 저장
			max_height = temp_height;

		i++;
	}


	// 최종적으로 스택이 비어 있으면 산이 만들어 진 것. 산의 높이를 출력한다.
	// 그렇지 않을 경우 0을 출력

	if (IsEmpty())
		printf("%d", max_height);
	else
		printf("0");


	printf("\n");
	return 0;

}