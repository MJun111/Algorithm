#include <iostream>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000000 + 1

int n, u, v;
vector<int> tree[MAX];
bool visited[MAX];
int dp[MAX][2];         // 0 : 얼리어답터, 1 : 일반인

void input()
{
    cin >> n;
    for (int i = 1; i <= n - 1; i++)
    {
        cin >> u >> v;
        tree[u].push_back(v);
        tree[v].push_back(u);
    }
}

void solve(int x)
{
    visited[x] = true;
    dp[x][0] = 1;

    for (int i = 0; i < tree[x].size(); i++)
    {
        int c = tree[x][i];
        if (visited[c])
            continue;
        solve(c);
        dp[x][1] += dp[c][0];
        dp[x][0] += min(dp[c][0], dp[c][1]);
    }
}

void solution()
{
    solve(1);
    cout << min(dp[1][0], dp[1][1]) << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}