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
vector<int> dp(MAX, INT_MAX);   // i ��° �̸��� ���ο� �ٿ��� �������� ��, ��ĭ ������ �ּҰ�

void input()
{
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
        cin >> name[i];
}

int solve(int idx)
{
    // �̹� ��� ���� ��� ����
    if (dp[idx] < INT_MAX)
        return dp[idx];

    // rem : �̸��� ���̰� ���� ���� -> �ڿ� ���� �̸��� �̾���� �� ������ ������ ���
    int rem = m - name[idx];

    // i ��° �̸��� �̾� �ٿ� ����, rem >= 0 �� ����
    for (int i = idx + 1; i <= n + 1 && rem >= 0; i++)
    {
        // �̸��� ��� �̾�ٿ� ���� �ѱ��� �ʾ��� ��� -> ������ ��
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