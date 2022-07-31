#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define INF 987654321

int n;
int order[100001];
int dp[5][5][100001];
int toward[5][5];           // [a][b] : a -> b ºñ¿ë

void input()
{
    int i = 1;
    while (1)
    {
        cin >> order[i++];
        if (order[i - 1] == 0)
        {
            n = i - 1;
            break;
        }
    }
}

void toward_set()
{
    for (int i = 0; i <= 4; i++)
        toward[i][i] = 1;
    for (int i = 1; i <= 4; i++)
        toward[0][i] = 2;

    toward[1][2] = toward[1][4] = toward[2][1] = toward[2][3] = toward[3][2] = toward[3][4] = toward[4][1] = toward[4][3] = 3;
    toward[1][3] = toward[2][4] = toward[3][1] = toward[4][2] = 4;

}

int getDP(int l, int r, int cur)
{
    if (cur == n - 1) return 0;
    if ((l != 0 && r != 0) && l == r) return INF;

    if (dp[l][r][cur] != -1) return dp[l][r][cur];

    return dp[l][r][cur] = min((getDP(order[cur + 1], r, cur + 1) + toward[l][order[cur + 1]]), (getDP(l, order[cur + 1], cur + 1) + toward[r][order[cur + 1]]));
}

void solution()
{
    toward_set();
    memset(dp, -1, sizeof(dp));
    cout << getDP(0, 0, 0);
}

int main()
{
    FAST
        input();
    solution();

    return 0;
}