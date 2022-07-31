#include <iostream>
#include <queue>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 500 + 1

int n, m;
int x, y;
int dir[8][2] = { {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1} };
int dist[MAX][MAX];
bool visited[MAX][MAX];
vector<pair<int, int>> goal;

void input()
{
    cin >> n >> m;
    cin >> x >> y;
    for (int i = 0; i < m; i++)
    {
        int a, b;
        cin >> a >> b;
        goal.push_back({ a, b });
    }
}

void BFS()
{
    visited[y][x] = true;
    dist[y][x] = 0;

    queue<pair<int, int>> q;
    q.push({ x, y });

    while (!q.empty())
    {
        int _x = q.front().first;
        int _y = q.front().second;
        q.pop();

        for (int i = 0; i < 8; i++)
        {
            int nx = _x + dir[i][0];
            int ny = _y + dir[i][1];

            if (nx < 0 || ny < 0 || nx > n || ny > n) continue;
            if (visited[ny][nx]) continue;

            visited[ny][nx] = true;
            q.push({ nx, ny });
            dist[ny][nx] = dist[_y][_x] + 1;
        }
    }
}

void solution()
{
    BFS();

    for (int i = 0; i < goal.size(); i++)
    {
        int X = goal[i].first;
        int Y = goal[i].second;
        cout << dist[Y][X] << " ";
    }

}

int main()
{
    FAST
    input();
    solution();

    return 0;
}