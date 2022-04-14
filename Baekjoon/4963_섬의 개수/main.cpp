#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 50 + 1

int w, h;
int map[MAX][MAX];
bool visited[MAX][MAX];
int dir[8][2] = { {1, 0}, {0, 1}, {-1,0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1} };

void input()
{
	cin >> w >> h;
	if (w == 0 && h == 0)
		exit(0);

	for (int i = 0; i < h; i++)
		for (int j = 0; j < w; j++)
			cin >> map[i][j];
}

void BFS(int a, int b)
{
	queue<pair<int, int>> q;
	q.push({ a, b });

	while (!q.empty())
	{
		int r = q.front().first;
		int c = q.front().second;
		q.pop();

		for (int i = 0; i < 8; i++)
		{
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];

			if (nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
			if (!map[nr][nc]) continue;
			if (visited[nr][nc]) continue;

			visited[nr][nc] = true;
			q.push({ nr, nc });
		}
	}
}

void solution()
{
	int cnt = 0;
	for (int i = 0; i < h; i++)
		for (int j = 0; j < w; j++)
		{
			if (map[i][j] == 1 && !visited[i][j])
			{
				visited[i][j] = true;
				BFS(i, j);
				cnt++;
			}
		}
	cout << cnt << "\n";

	memset(map, 0, sizeof(map));
	memset(visited, false, sizeof(visited));
}

int main()
{
	FAST
	while (1)
	{
		input();
		solution();
	}
	return 0;
}