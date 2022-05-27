#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100001

int t, n;
int dp[MAX];

void solution()
{
    cin >> t;
    for (int tc = 1; tc <= t; tc++)
    {
        cin >> n;
        int maxNum = -1001;
        for (int i = 1; i <= n; i++)
        {
            int num;
            cin >> num;
            if (dp[i - 1] + num > num)
                dp[i] = dp[i - 1] + num;
            else
                dp[i] = num;
        }
        for (int i = 1; i <= n; i++)
            maxNum = max(maxNum, dp[i]);

        cout << "#" << tc << " " << maxNum << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}