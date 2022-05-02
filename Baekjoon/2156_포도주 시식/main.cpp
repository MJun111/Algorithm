#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 10000 + 1

int n;
int wine[MAX];
int dp[MAX];

void input()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
        cin >> wine[i];
}

void solution()
{
    dp[1] = wine[1];
    dp[2] = wine[1] + wine[2];

    for (int i = 3; i <= n; i++)
        dp[i] = max(max(dp[i - 3] + wine[i - 1] + wine[i], dp[i - 2] + wine[i]), dp[i - 1]);
    
    cout << dp[n] << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}