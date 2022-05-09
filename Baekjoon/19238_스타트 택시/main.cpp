#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 20 + 1

int n, m, fuel;
int map[MAX][MAX];
pair<int, int> taxi;
vector<pair<int, int>> st, fin;
int dir[4][2] = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
bool visited[MAX][MAX];

struct Taxi
{
	int r;
	int c;
	int f;
};

void input()
{
	cin >> n >> m >> fuel;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> map[i][j];

	cin >> taxi.first >> taxi.second;

	for (int i = 0; i < m; i++)
	{
		int r1, r2, c1, c2;
		cin >> r1 >> c1 >> r2 >> c2;
		st.push_back({ r1, c1 });
		fin.push_back({ r2, c2 });
		map[r1][c1] = i + 2;
	}

}

void BFS()
{
	bool trigger = false;
	int tmpf = -1;
	pair<int, int> goal = { -1, -1 };
	queue<Taxi> q;

	q.push({ taxi.first, taxi.second, fuel });
	while (!q.empty())
	{
		int r = q.front().r;
		int c = q.front().c;
		int f = q.front().f;
		q.pop();

		if (m <= 0)
		{
			cout << f << "\n";
			exit(0);
		}

		if (f == 0 && r != goal.first && c != goal.second)
		{
			cout << "-1\n";
			exit(0);
		}
		else if (f < 0)
		{
			cout << "-1\n";
			exit(0);
		}

		for (int i = 0; i < 4; i++)
		{
			int dr = r + dir[i][0];
			int dc = c + dir[i][1];

			if (dr < 0 || dr >= n || dc < 0 || dc >= n) continue;
			if (map[dr][dc] == 1) continue;
			if (visited[dr][dc]) continue;
			visited[dr][dc] = true;
			q.push({ dr, dc, f - 1 });

			if (!trigger && map[dr][dc] >= 2)
			{
				while (!q.empty())
					q.pop();

				memset(visited, false, sizeof(visited));
				visited[dr][dc] = true;
				trigger = true;
				tmpf = f;

				goal.first = fin[map[dr][dc] - 2].first;
				goal.second = fin[map[dr][dc] - 2].second;
				q.push({ dr, dc, f - 1 });
				cout << "intoTrig\n";
			}

			if (trigger && dr == goal.first && dc == goal.second)
			{
				while (!q.empty())
					q.pop();

				memset(visited, false, sizeof(visited));
				visited[dr][dc] = true;
				trigger = false;
				m--;

				q.push({ dr, dc, 2 * (tmpf - f) - 1 });
				goal.first = -1;
				goal.second = -1;
				cout << "outTrig\n";
			}
		}
	}
}

void solution()
{
	BFS();
}

int main()
{
	FAST
		input();
	solution();

	return 0;
}