#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100001

int n, k;
int minTime = MAX;
bool visited[MAX];
int parent[MAX];
vector<int> path;

void BFS(int n, int k)
{
    queue<pair<int, int>> q;

    q.push({ n, 0 });
    visited[n] = true;

    while (!q.empty())
    {
        int curLocate = q.front().first;
        int curTime = q.front().second;
        q.pop();

        if (curLocate == k)                 // 목적지 도착 시
        {
            if (minTime > curTime)          // 최소 시간보다 현재 시간이 적다면 갱신
            {
                minTime = curTime;
            }

            int idx = curLocate;

            while (idx != n)
            {
                path.push_back(idx);
                idx = parent[idx];
            }
            path.push_back(n);

            return;
        }

        if (curLocate + 1 < MAX && !visited[curLocate + 1])
        {
            parent[curLocate + 1] = curLocate;
            q.push({ curLocate + 1, curTime + 1 });
            visited[curLocate + 1] = true;
        }
        if (curLocate - 1 >= 0 && !visited[curLocate - 1])
        {
            parent[curLocate - 1] = curLocate;
            q.push({ curLocate - 1, curTime + 1 });
            visited[curLocate - 1] = true;
        }
        if (curLocate * 2 < MAX && !visited[curLocate * 2])
        {
            parent[curLocate * 2] = curLocate;
            q.push({ curLocate * 2, curTime + 1 });
            visited[curLocate * 2] = true;
        }
    }
}

void input()
{
    cin >> n >> k;
}

void solution()
{
    BFS(n, k);
    cout << minTime << "\n";
    for (int i = path.size() - 1; i >= 0; i--)
        cout << path[i] << " ";
}

int main(void)
{
    FAST
        input();
    solution();

    return 0;
}
