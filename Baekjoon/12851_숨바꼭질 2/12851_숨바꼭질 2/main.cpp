#include <iostream>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100001

int n, k;
int minTime = MAX;
int minCase = 0;
bool visited[MAX];

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

        visited[curLocate] = true;

        if (curLocate == k)                 // 목적지 도착 시
        {
            if (minTime > curTime)          // 최소 시간보다 현재 시간이 적다면 갱신
            {
                minTime = curTime;
                minCase = 1;                // 찾는 방법의 수 1부터 카운트
            }
            else if (minTime == curTime)    // 같은 도달 시간으로 새로운 경우가 나올 경우 찾는 방법의 수 추가
                minCase++;
        }

        if (curLocate + 1 < MAX && !visited[curLocate + 1])
            q.push({ curLocate + 1, curTime + 1 });
        if (curLocate - 1 >= 0 && !visited[curLocate - 1])
            q.push({ curLocate - 1, curTime + 1 });
        if (curLocate * 2 < MAX && !visited[curLocate * 2])
            q.push({ curLocate * 2, curTime + 1 });
    }
}

void input()
{
    cin >> n >> k;
}

void solution()
{
    BFS(n, k);
    cout << minTime << "\n" << minCase;
}

int main(void)
{
    FAST
    input();
    solution();

    return 0;
}
