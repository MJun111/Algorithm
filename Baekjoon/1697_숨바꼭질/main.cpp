#include <iostream>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int n, k;
int cnt[MAX];
bool visited[MAX];

void input()
{
    cin >> n >> k;
}

void BFS()
{
    queue<int> q;
    q.push(n);

    cnt[n] = 0;
    visited[n] = true;

    while (!q.empty())
    {
        int cur = q.front();
        q.pop();

        if (cur == k)
            break;

        if (0 <= cur - 1 && cur - 1 < MAX && !visited[cur - 1])
        {
            visited[cur - 1] = true;
            cnt[cur - 1] = cnt[cur] + 1;
            q.push(cur - 1);
        }

        if (0 <= cur + 1 && cur + 1 < MAX && !visited[cur + 1])
        {
            visited[cur + 1] = true;
            cnt[cur + 1] = cnt[cur] + 1;
            q.push(cur + 1);
        }

        if (0 <= cur * 2 && cur * 2 < MAX && !visited[cur * 2])
        {
            visited[cur * 2] = true;
            cnt[cur * 2] = cnt[cur] + 1;
            q.push(cur * 2);
        }
    }
}

void solution()
{
    BFS();
    cout << cnt[k] << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}