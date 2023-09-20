#include <stdio.h>
#include <stdlib.h>
#pragma warning(disable: 4996)

#define N 100

int n, m, x[N];
int seq[N][2];

int reverse(int* array, int l, int r);
int getScore(int* array);
int move(int cnt);

int main() {
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) 
        scanf("%d", &x[i]);

    int cnt = 0;
    while(cnt < m){
        move(cnt);
        cnt++;
    }

	// find a sequence of reverses to minimize the score and store the sequence to an array, seq
	for (int i = 0; i < m; i++) {
		printf("%d %d\n", seq[i][0], seq[i][1]);
	}

	return 0;
}

// l to r reverse
int reverse(int* array, int l, int r){
    int* sorted = (int*)malloc(sizeof(int) * n);

    int idx = l;
    for(int i = r; i >=l; i--){
        sorted[idx] = array[i];
        idx++;
    }

    for(int i = l; i <= r; i++){
        array[i] = sorted[i];
    }

    free(sorted);

    return 0;
}


int getScore(int* array){
    int cnt;
    int score = 0;

    for(int i = 0; i < n - 1; i++){
        cnt  = 1;
        while(array[i] == array[i + 1]){
            cnt++;
            i++;
        }
        if(cnt > 1) 
            score += array[i] * cnt;
    }
    return score;
}

int move(int cnt){
    int i, j, k;
    int start = -1, end = -1, min_score = 0, temp_score = 0;
    int * temp_x;

    temp_x = (int *)malloc(sizeof(int)*n);
   
    // present score
    min_score = getScore(x);

   for (i = 0; i < n; i++) {
      for (j = i + 1; j < n; j++) {
         // temp_x initialize 
         for (k = 0; k < n; k++) {
            temp_x[k] = x[k];
         }
         // i ~ j reverse, find minimum score
         reverse(temp_x, i, j);
         temp_score = getScore(temp_x);
         if (temp_score < min_score) {
            min_score = temp_score;
            start = i; end = j;
         }
      }
   }
   
   // the case that do reverse 
   if ((start != -1) && (end != -1)) {
      seq[cnt][0] = start;
      seq[cnt][1] = end;
      reverse(x,start,end);
   }
   // the case that don't reverse
   else {
      seq[cnt][0] = 0;
      seq[cnt][1] = 0;
   }

   return 0;
}