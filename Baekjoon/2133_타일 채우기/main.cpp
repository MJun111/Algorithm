#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 30 + 1

int n;
int dp[MAX];

void input()
{
    cin >> n;
    if (n % 2 == 1)
    {
        cout << "0\n";
        exit(0);
    }
}

void solution()
{
    dp[0] = 1;
    dp[2] = 3;
    
    for (int i = 4; i <= n; i += 2)
    {
        dp[i] = dp[i - 2] * dp[2];                  
        for (int j = i - 4; j >= 0; j -= 2)         // dp[i-4] * 2 + dp[i-6] * 2 + ... + dp[0] * 2 (매 회 특별한 모양이 2개씩 출현)  
            dp[i] += dp[j] * 2;
    }
    cout << dp[n];
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}