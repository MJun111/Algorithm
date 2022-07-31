#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int t, n;
long long dp[MAX];

void solution()
{
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 2;
    dp[4] = 3;
    dp[5] = 3;

    for (int i = 6; i < MAX; i++)
        dp[i] = (dp[i-6] + dp[i-4] + dp[i-2]) % 1000000009; 
    
    cin >> t;
    while (t-- > 0)
    {
        cin >> n;
        cout << dp[n] << "\n";
    }
    
}

int main()
{
    FAST
    solution();

    return 0;
}