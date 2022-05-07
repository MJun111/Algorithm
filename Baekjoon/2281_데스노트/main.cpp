#include <iostream>
#include <climits>
#include <cstring>
#include <algorithm>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000 + 1

int n, m;
vector<int> name(MAX, 0);
vector<int> dp(MAX, INT_MAX);   // i 번째 이름을 새로운 줄에서 시작했을 때, 빈칸 제곱의 최소값

void input()
{
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
        cin >> name[i];
}

int solve(int idx)
{
    // 이미 계산 했을 경우 리턴
    if (dp[idx] < INT_MAX)
        return dp[idx];

    // rem : 이름을 붙이고 남은 공간 -> 뒤에 다음 이름을 이어붙일 수 있을지 결정에 사용
    int rem = m - name[idx];

    // i 번째 이름을 이어 붙여 가봄, rem >= 0 인 동안
    for (int i = idx + 1; i <= n + 1 && rem >= 0; i++)
    {
        // 이름을 계속 이어붙여 줄을 넘기지 않았을 경우 -> 마지막 줄
        if (i == n + 1)
        {
            dp[idx] = 0;
            break;
        }

        dp[idx] = min(dp[idx], rem * rem + solve(i));
        rem -= name[i] + 1;
    }

    return dp[idx];
}

void solution()
{
    dp[n] = 0;
    cout << solve(1) << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}