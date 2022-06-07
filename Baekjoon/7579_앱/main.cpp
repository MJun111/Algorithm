#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int n, m, sum;
pair<int, int> app[101];        // first : �޸�, second : ���
int dp[101][10001];             // dp[i][j] : i��° �۱��� Ž�� ���� �� j����� �Ҹ��Ͽ� ���� �� �ִ� �ִ� �޸�

void input()
{
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
        cin >> app[i].first;
    for (int i = 1; i <= n; i++)
    {
        cin >> app[i].second;
        sum += app[i].second;
    }
}

void solution()
{
    for (int i = 1; i <= n; i++)
        for (int j = 0; j <= sum; j++)
        {
            if (j - app[i].second >= 0)
                dp[i][j] = dp[i - 1][j - app[i].second] + app[i].first;

            dp[i][j] = max(dp[i][j], dp[i - 1][j]);
        }

    for (int i = 0; i <= sum; i++)
        if (dp[n][i] >= m)
        {
            cout << i << "\n";
            break;
        }
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}