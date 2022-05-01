#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 10000 + 1

int n;
int dp[MAX], p[MAX];

void input()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
        cin >> p[i];
}

void solution()
{
    dp[1] = p[1];

    for (int i = 2; i <= n; i++)
        for (int j = 1; j <= i; j++)
            dp[i] = max(dp[i], dp[i - j] + p[j]);
    
    cout << dp[n] << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}