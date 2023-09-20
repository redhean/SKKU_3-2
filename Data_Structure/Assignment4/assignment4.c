#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#pragma warning(disable: 4996)

#define MAX(a, b) ((a > b) ? a : b)
int T;
int V[1001];


// AVL 트리 구조체 선언
typedef struct AVL_treeNode {
    int key;
    struct AVL_treeNode* left;
    struct AVL_treeNode* right;
}treeNode;

// RR_rotate
treeNode* RR_rotate(treeNode* parent) {
    treeNode* child = parent->left;
    parent->left = child->right;
    child->right = parent;
    return child;
}

// LL_rotate
treeNode* LL_rotate(treeNode* parent) {
    treeNode* child = parent->right;
    parent->right = child->left;
    child->left = parent;
    return child;
}

// LR_rotate
treeNode* LR_rotate(treeNode* parent) {
    treeNode* child = parent->left;
    parent->left = LL_rotate(child);
    return RR_rotate(parent);
}

// RL_rotate
treeNode* RL_rotate(treeNode* parent) {
    treeNode* child = parent->right;
    parent->right = RR_rotate(child);
    return LL_rotate(parent);
}

// 서브 트리의 높이 구하기
int getHeight(treeNode* p) {
    int height = 0;
    if (p != NULL)
        height = MAX(getHeight(p->left), getHeight(p->right)) + 1;

    return height;
}

// Balance Factor 구하기 -> 저는 여기서 Balance Factor를 Left - Right로 구했습니다.
int getBF(treeNode* p) {
    if (p == NULL) return 0;
    return getHeight(p->left) - getHeight(p->right);
}

// BF를 검사하여 불균형이 있으면 정리
treeNode* rebalance(treeNode** p) {
    int BF = getBF(*p);

    if (BF > 1) {
        if (getBF((*p)->left) > 0)
           *p = RR_rotate(*p);
        else
            *p = LR_rotate(*p);
    }
    else if (BF < -1) {
        if (getBF((*p)->right) < 0)
            *p = LL_rotate(*p);
        else
            *p = RL_rotate(*p);
    }
    return *p;
}
// 노드 삽입(최대 높이 o)
treeNode* insertNode_max(treeNode** root, int x) {
    if (*root == NULL) {
        *root = (treeNode*)malloc(sizeof(treeNode));
        (*root)->key = x;
        (*root)->left = NULL;
        (*root)->right = NULL;
    }
    else if (getBF(*root) == 0) {
        (*root)->left = insertNode_max(&((*root)->left), x);
    }
    else if (getBF(*root) != 0) {
        (*root)->right = insertNode_max(&((*root)->right), x);
    }

    return *root;
}
// 노드 삽입(최대 높이 x)
treeNode* insertNode(treeNode** root, int x) {
    if (*root == NULL) {
        *root = (treeNode*)malloc(sizeof(treeNode));
        (*root)->key = x;
        (*root)->left = NULL;
        (*root)->right = NULL;
    }
    else if (x < (*root)->key) {
        (*root)->left = insertNode(&((*root)->left), x);
           *root = rebalance(root);
    }
    else if (x > (*root)->key) {
        (*root)->right = insertNode(&((*root)->right), x);
           *root = rebalance(root);
    }
    else {
        printf("중복된 키가 존재\n");
        exit(1);
    }

    return *root;
}

// Maximum formula
int getMaximumHeight(int n) {
    int height;
    double n1 = (double)n;
    
    if (n == 1) return 1;
    else if (n == 2) return 2;
    else
        height = floor(1.44 * log2(n1 + 2.0) - 0.328);

    return height;
}

void PrintInorder(treeNode* root) {
    if (root) {
        PrintInorder(root->left);
        printf("_%d", root->key);
        PrintInorder(root->right);
    }
}

int main() {
    scanf("%d", &T);
    for (int i = 0; i < T; i++) {
        scanf("%d", &V[i]);
    }

    for(int i = 0; i < T; i++){
        printf("%d\n", getMaximumHeight(V[i]));
    }
 
    int key[20] = { 12, 7, 17, 4, 15, 10, 2, 19, 14, 9, 6, 1, 18, 16, 13, 11, 8, 5, 3, 0 };
    treeNode* AVL_root = NULL;
    for (int i = 0; i < 20; i++) {
        insertNode_max(&AVL_root, key[i]);
        AVL_root = rebalance(&AVL_root);
        PrintInorder(AVL_root);
        printf("        현재 트리 높이 : %d\n", getHeight(AVL_root));
    }
    return 0;
}


