#include <iostream>
#include <string>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 5000 + 1
#define MOD 1000000

string s;
long long dp[MAX];

void input()
{
    cin >> s;
}

void solution()
{
    int len = s.size();
    s = " " + s;

    dp[0] = 1;
    for (int i = 1; i <= len; i++)
    {
        int x = s[i] - '0';
        if (x > 0)
            dp[i] = dp[i - 1] % MOD;

        if (i == 1 || s[i - 1] == '0')
            continue;

        x = (s[i - 1] - '0') * 10 + (s[i] - '0');
        if (x >= 10 && x <= 26)
            dp[i] = (dp[i] + dp[i - 2]) % MOD;
    }

    cout << dp[len] << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}