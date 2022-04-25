#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100 + 1

int n, m, x, y, k;
vector<pair<int, int>> config[MAX];
int inDeg[MAX], cnt[MAX];
vector<int> ans;

void input()
{
    cin >> n;
    cin >> m;
    for (int i = 1; i <= m; i++)
    {
        cin >> x >> y >> k;
        inDeg[y]++;
        config[x].push_back({ y, k });
    }
}

void solution()
{
    queue<int> q;
    q.push(n);
    cnt[n] = 1;

    while (!q.empty())
    {
        int cur = q.front();
        q.pop();

        if (config[cur].empty())
            ans.push_back(cur);

        for (auto x : config[cur])
        {
            int next = x.first;
            int num = x.second;

            inDeg[next]--;
            cnt[next] += cnt[cur] * num;
            if (inDeg[next] == 0)
                q.push(next);
        }
    }
    sort(ans.begin(), ans.end());
    for (int x : ans)
        cout << x << " " << cnt[x] << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}