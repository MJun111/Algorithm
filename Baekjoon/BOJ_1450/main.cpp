#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int n, c, ans;
int w[31];
vector<long long> group1;
vector<long long> group2;

void input()
{
    cin >> n >> c;
    for (int i = 0; i < n; i++)
        cin >> w[i];
}

void DFS(int s, int e, vector<long long>& v, long long sum)
{
    if (s > e)
    {
        v.push_back(sum);
        return;
    }
    else
    {
        DFS(s + 1, e, v, sum);
        DFS(s + 1, e, v, sum + w[s]);
    }
}

void solution()
{
    DFS(0, n / 2, group1, 0);
    DFS(n / 2 + 1, n - 1, group2, 0);
    sort(group2.begin(), group2.end());

    for (int i = 0; i < group1.size(); i++)
        ans += upper_bound(group2.begin(), group2.end(), c - group1[i]) - group2.begin();

    cout << ans << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}