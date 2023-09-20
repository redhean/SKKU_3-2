#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#pragma warning(disable: 4996)

int R, C;   // row and column
char graph[21][21];     // for input data
int visited[21][21];    // not visited = 0 , visited = 1
int alphabet[27];       // not visited = 0 , visited = 1


// STACK
#define STACK_SIZE 20     

int stack[STACK_SIZE + 1];
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

void push(int item) {
	if (IsFull())
		printf("Error! Stack is full!");
	else stack[++top] = item;
}

int pop() {
	if (IsEmpty())
		printf("Error! Stack is empty!");
	else 
        return stack[top--];
}

int main(){
    scanf("%d %d", &R, &C);
    getchar();
    for(int i = 0; i < R; i++){
        for(int j = 0; j < C; j++)
            scanf("%c", &graph[i][j]);
        getchar();
    }

    int max = 1;
    
    // initialize
    int cur = 0;
    push(cur);
    int pre_pre = -1;    

    
    while(1){
        visited[0][0] = 1;
        alphabet[graph[0][0] - 'A'] = 1;
        int i = cur / C; // row
        int j = cur % C; // col
        int move = 0;
        int temp_max = 0;


        // right
        if(j < C - 1 && visited[i][j + 1] == 0 && alphabet[graph[i][j + 1] - 'A'] == 0){
            printf("right\n");
            cur = (i)* C + j + 1;
            push(cur);
            visited[i][j + 1] = 1;
            alphabet[graph[i][j + 1] - 'A'] = 1;
            move = 1;
        }

        // down
        else if(i < R - 1 && visited[i + 1][j] == 0 && alphabet[graph[i + 1][j] - 'A'] == 0){
            printf("down\n");
            cur = (i+1)* C + j;
            push(cur);
            visited[i + 1][j] = 1;
            alphabet[graph[i + 1][j] - 'A'] = 1;
            move = 1;
        }

        // up
        else if(i > 0 && visited[i - 1][j] == 0 && alphabet[graph[i - 1][j] - 'A'] == 0){
            printf("up\n");
            cur = (i-1)* C + j;
            push(cur);
            visited[i - 1][j] = 1;
            alphabet[graph[i - 1][j] - 'A'] = 1;
            move = 1;
        }
        
        // left
        else if(j > 0 && visited[i][j - 1] == 0 && alphabet[graph[i][j - 1] - 'A'] == 0){
            printf("left\n");
            cur = (i)* C + j - 1;
            push(cur);
            visited[i][j - 1] = 1;
            alphabet[graph[i][j - 1] - 'A'] = 1;
            move = 1;
        }
        

        if(move == 0){
            if(IsEmpty()){
                 break;
            }
            else{
                for(int i = 0; i < 27; i++){
                    if(alphabet[i] != 0)
                        temp_max++;
                }    
                if(max < temp_max)
                    max = temp_max;


                int pre = pop();
                printf("pop!\n");
                alphabet[graph[pre / C][pre % C] - 'A'] = 0;
                cur = stack[top];
                
            }
        }

    }
    printf("%d\n", max);
    for(int i = 0; i < R; i++){
        for(int j = 0; j < C; j++){
            printf("%d ", visited[i][j]);
        }
        printf("\n");
    }
    return 0;
}
