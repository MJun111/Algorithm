#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 300 + 1

int n;
int arr[MAX], dp[MAX][2];

void input()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
        cin >> arr[i];
}

void solution()
{
    dp[1][0] = arr[1];
    dp[2][0] = arr[2];
    dp[2][1] = arr[1] + arr[2];

    for (int i = 3; i <= n; i++)
    {
        dp[i][0] = max(dp[i - 2][0], dp[i - 2][1]) + arr[i];    // [i][0] : i-1번째 계단을 밟지 않고 온 최댓 값
        dp[i][1] = max(dp[i - 1][0], dp[i - 2][1]) + arr[i];    // [i][1] : i-1번째 계단을 밟고 온 최댓 값
    }
    cout << max(dp[n][0], dp[n][1]);
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}