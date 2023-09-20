#include <stdio.h>
#include <stdlib.h>
#pragma warning(disable: 4996)

int n,m;
int graph[10001][10001];

int main(){
    scanf("%d %d", &n, &m);
    int* color = (int*)malloc(sizeof(int) * n);


    // the color should be start at 0 and add by 1 when add new color
    for(int i = 0; i < n; i++){
        scanf("%d", &color[i]);
    }

    for(int i = 0; i < m; i++){
        int a, b;
        scanf("%d %d", &a, &b);

        graph[a][b] = 1;
        graph[b][a] = 1;
    }

    int cnt = 0;
    int temp_cnt;
    int max_color = 0;
    
    for(int i = 0; i <n; i++){
        if(color[i] > max_color)
            max_color = color[i];
    }

    int * color_cnt = (int*)malloc(sizeof(int) * max_color);
    for(int i = 0; i < n; i++){
        color_cnt[color[i]]++;
    }

    for(int i = 0; i <= max_color; i++){
        temp_cnt = 0;
        for(int j = 0; j < n; j++){
            for(int k = j + 1; k < n; k++){
                if(color[j] == i && color[k] == i && graph[j][k] == 1){
                    temp_cnt++;
                }
                else
                    continue;
            }
        }
        if(temp_cnt != 0){
             if(temp_cnt >= color_cnt[i] - 1)
                continue;
             else
                cnt += (color_cnt[i] - temp_cnt - 1);
        }
        else
            cnt += (color_cnt[i] - temp_cnt - 1);
    }

    cnt += max_color + 1;
    printf("%d\n", cnt);
}
