#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100 + 1

int n, m;     
int time = 0;
int board[MAX][MAX];
bool air[MAX][MAX];      // 바깥 공기 영역

void input()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cin >> board[i][j];
}

void solution()
{

}

int main()
{
    FAST
    input();
    solution();

    return 0;
}