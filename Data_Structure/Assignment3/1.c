#include <stdio.h>
#include <stdlib.h>

int preorder[10001];
int inorder[10001];
int N;
int cnt = 0; // count the index of preorder

int toPostorder(int start, int end, int index){
    // break point, if start and end is same, then print out inorder[start] or inorder[end] and return 0.
        // when the parent node has two child nodes
    if(start == end){
        printf("%d ", inorder[start]);
        return 0;
    }
        // when the parent node has one child nodes
    else if(end - start == 1){
        if(preorder[cnt] == inorder[start])
            printf("%d %d ", inorder[end], inorder[start]);
        else
            printf("%d %d ", inorder[start], inorder[end]);
            
        cnt++;
        return 0;
    }

    // get root and mid
    int mid = -1;
    int root = preorder[index];
    for(int i = 0; i < end; i++){
        if(inorder[i] == root)
            mid = i;
    }

    // recursion
    if(mid > 0 && index < N - 1){
        // reading whole inorder value by adding 1 to cnt.
        cnt++;
        toPostorder(start, mid - 1, cnt);
        cnt++;
        toPostorder(mid + 1, end, cnt);
        printf("%d ", root);
    }

    return 0;

}

int main(){
    // get input
    scanf("%d", &N);
    for(int i = 0; i < N; i++){
        scanf("%d", &preorder[i]);
    }
    for(int i = 0; i < N; i++){
        scanf("%d", &inorder[i]);
    }

    toPostorder(0, N - 1, cnt);
    printf("\n");

    return 0;
}