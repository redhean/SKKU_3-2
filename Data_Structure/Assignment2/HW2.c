#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#pragma warning(disable : 4996)

int chk = 0;

typedef struct Node_t {
	char data;
    int lanchk;
	struct Node_t* next;
}Node;

typedef struct {
	Node* head;
	int len;
    int cursor;
}LinkedList;

LinkedList* InitList(void) {
	LinkedList* h;
	h = (LinkedList*)malloc(sizeof(LinkedList));
	h->head = NULL;
	h->len = 0;
    h->cursor = 0;
	return h;
}

bool IsEmpty(LinkedList* h) {
	return h->len == 0;
}

void Add(LinkedList* h, char item){
    // if lanchk == 0 English
    // if lanchk == 1 Korean
    Node* cur;
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->next = NULL;
    newNode->lanchk = chk;

    if(item == '_')
        newNode->data = ' ';
    else
        newNode->data = item;
    
    if (h->head == NULL) {
		h->head = newNode;
		h->len++;
        h->cursor++;
		return;
    }
    if(h->cursor == 0){
        newNode->next = h->head;
        h->head = newNode;
        h->len++;
        h->cursor++;
        return;
    }
    else{
        cur = h->head;
        for(int i = 0; i < h->cursor-1; i++){
            cur = cur->next;
        }
        newNode->next = cur->next;
        cur->next = newNode;
        h->len++;
        h->cursor++;
        return;
    }
}

void Erase(LinkedList* h){
    if(h->cursor == 0 || IsEmpty(h))
        return;
    else{
        Node* cur;

        cur = h->head;
        if(h->cursor == 1){
            h->head = cur->next;
            free(cur);
            h->len--;
            h->cursor--;
        }
        else{
            for(int i = 0; i < h->cursor-2; i++)
                cur = cur->next;
            
            Node* temp = cur->next;
            cur->next = cur->next->next;
            free(temp);
            h->len--;
            h->cursor--;
        }
    }
}


int main(){
   int N;
    scanf("%d",&N);    
    LinkedList* h = InitList();
    int cnt = 0;
    char cmd_type[9];

   while(cnt != N){
        scanf("%s", cmd_type);

        if (!strcmp(cmd_type, "move")){
            cnt++;
            char dir;
            scanf(" %c", &dir);
            if(dir == 'l'){
                if(h->cursor != 0)
                    h->cursor--;
            }
            else if(dir == 'r'){
                if(h->cursor != h->len)
                    h->cursor++;
            }
        }
        else if (!strcmp(cmd_type, "add")){
            cnt++;
            char item;
            scanf(" %c", &item);
            Add(h,item);
        }
        else if (!strcmp(cmd_type, "language")){
            cnt++;
            if(chk == 0)
                chk = 1;
            else
                chk = 0;
        }
        else if (!strcmp(cmd_type, "erase")){
            cnt++;
            Erase(h);

        }
    }

    Node* cur;
    cur = h->head;
    while(cur != NULL){
        if(cur->lanchk == 0)
            printf("%c", cur->data);
        else{
            if(cur->data == 'a' || cur->data == 'A') printf("%s", "ㅁ");
            else if(cur->data == 'b' || cur->data == 'B') printf("%s", "ㅠ");
            else if(cur->data == 'c' || cur->data == 'C') printf("%s", "ㅊ");
            else if(cur->data == 'd' || cur->data == 'D') printf("%s", "ㅇ");
            else if(cur->data == 'e' || cur->data == 'E') printf("%s", "ㄷ");
            else if(cur->data == 'f' || cur->data == 'F') printf("%s", "ㄹ");
            else if(cur->data == 'g' || cur->data == 'G') printf("%s", "ㅎ");
            else if(cur->data == 'h' || cur->data == 'H') printf("%s", "ㅗ");
            else if(cur->data == 'i' || cur->data == 'I') printf("%s", "ㅑ");
            else if(cur->data == 'j' || cur->data == 'J') printf("%s", "ㅓ");
            else if(cur->data == 'k' || cur->data == 'K') printf("%s", "ㅏ");
            else if(cur->data == 'l' || cur->data == 'L') printf("%s", "ㅣ");
            else if(cur->data == 'm' || cur->data == 'M') printf("%s", "ㅡ");
            else if(cur->data == 'n' || cur->data == 'N') printf("%s", "ㅜ");
            else if(cur->data == 'o' || cur->data == 'O') printf("%s", "ㅐ");
            else if(cur->data == 'p' || cur->data == 'P') printf("%s", "ㅔ");
            else if(cur->data == 'q' || cur->data == 'Q') printf("%s", "ㅂ");
            else if(cur->data == 'r' || cur->data == 'R') printf("%s", "ㄱ");
            else if(cur->data == 's' || cur->data == 'S') printf("%s", "ㄴ");
            else if(cur->data == 't' || cur->data == 'T') printf("%s", "ㅅ");
            else if(cur->data == 'u' || cur->data == 'U') printf("%s", "ㅕ");
            else if(cur->data == 'v' || cur->data == 'V') printf("%s", "ㅍ");
            else if(cur->data == 'w' || cur->data == 'W') printf("%s", "ㅈ");
            else if(cur->data == 'x' || cur->data == 'X') printf("%s", "ㅌ");
            else if(cur->data == 'y' || cur->data == 'Y') printf("%s", "ㅛ");
            else if(cur->data == 'z' || cur->data == 'Z') printf("%s", "ㅋ");

        }
        cur = cur->next;
    }

    printf("\n");
    return 0;
}