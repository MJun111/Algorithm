#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 9

int n, m;
int lab[MAX][MAX];
bool visited[MAX][MAX];
int wall;
int ans;
int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, -1, 0, 1 };
vector<pair<int, int>> way;
queue<pair<int, int>> q;

void input()
{
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= m; j++)
        {
            cin >> lab[i][j];
            if(lab[i][j] == 0)
				way.push_back({ i, j });
        }
}

int bfs()
{
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= m; j++)
		{
			visited[i][j] = false;

			if (lab[i][j] == 2)
				q.push({ i, j });
		}

	while (!q.empty())
	{
		int now_x = q.front().first;
		int now_y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++)
		{
			int next_x = now_x + dx[i];
			int next_y = now_y + dy[i];

			if (next_x < 1 || next_x > n || next_y < 1 || next_y > m) continue;
			if (lab[next_x][next_y] != 0) continue;
			if (visited[next_x][next_y]) continue;

			visited[next_x][next_y] = true;
			q.push({ next_x, next_y });
		}
	}

	// 탐색 후 빈칸세기
	int cnt = 0;
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= m; j++)
			if (lab[i][j] == 0 && !visited[i][j])
				cnt++;

	return cnt;
}

void makeWall()
{
	for (int i = 0; i < way.size(); i++)
		for (int j = i + 1; j < way.size(); j++)
			for (int k = j + 1; k < way.size(); k++)
			{
				// 벽 세우기
				lab[way[i].first][way[i].second] = 1;
				lab[way[j].first][way[j].second] = 1;
				lab[way[k].first][way[k].second] = 1;

				// 안전영역 최대크기 저장
				ans = max(ans, bfs());

				// 되돌려 놓기
				lab[way[i].first][way[i].second] = 0;
				lab[way[j].first][way[j].second] = 0;
				lab[way[k].first][way[k].second] = 0;
			}
}

void solution()
{
	makeWall();
	cout << ans << '\n';
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}