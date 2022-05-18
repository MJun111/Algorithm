#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 21

int n, m, fuel;
int map[MAX][MAX];
pair<int, int> taxi;
vector<pair<int, int>> st, fin;
int dir[4][2] = { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
bool visited[MAX][MAX];

void input()
{
	cin >> n >> m >> fuel;
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			cin >> map[i][j];
	cin >> taxi.first >> taxi.second;
	st.push_back({ -1, -1 });			// 0¹øÂ° Ã¤¿ì±â ¿ë ¾²·¹±â °ª
	fin.push_back({ -1, -1 });			
	for (int i = 1; i <= m; i++)
	{
		int r1, c1, r2, c2;
		cin >> r1 >> c1 >> r2 >> c2;
		map[r1][c1] = i + 1;			// i¹øÂ° ½Â°´ -> ¸Ê¿¡ i + 1·Î Ç¥½Ã
		st.push_back({ r1, c1 });		// st[i] : i¹øÂ° ½Â°´ ÁÂÇ¥
		fin.push_back({ r2, c2 });		// fin[i] : i¹øÂ° µµÂø ÁÂÇ¥
	}

}

vector<pair<int, int>> find_Passenger()
{
	vector<pair<int, int>> p;
	memset(visited, false, sizeof(visited));
	priority_queue<pair<int, pair<int, int>>> q;
	q.push(make_pair(0, make_pair(-taxi.first, -taxi.second)));
	visited[taxi.first][taxi.second] = true;

	while (!q.empty())
	{
		int r = -q.top().second.first;
		int c = -q.top().second.second;
		int dist = -q.top().first;
		q.pop();

		if (map[r][c] > 1)
		{
			p.push_back(make_pair(map[r][c] - 1, dist));
			map[r][c] = 0;
			break;
		}

		for (int i = 0; i < 4; i++)
		{
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];

			if (nr < 1 || nc < 1 || nr > n || nc > n) continue;
			if (visited[nr][nc]) continue;
			if (map[nr][nc] == 1) continue;

			visited[nr][nc] = true;
			q.push(make_pair(-(dist + 1), make_pair(-nr, -nc)));
		}
	}
	return p;
}

int arrive(int num)
{
	int p = -1;
	memset(visited, false, sizeof(visited));
	queue<pair<pair<int, int>, int>> q;
	q.push(make_pair(make_pair(st[num].first, st[num].second), 0));
	visited[st[num].first][st[num].second] = true;

	while (!q.empty())
	{
		int r = q.front().first.first;
		int c = q.front().first.second;
		int dist = q.front().second;
		q.pop();

		if (r == fin[num].first && c == fin[num].second)
		{
			p = dist;
			break;
		}

		for (int i = 0; i < 4; i++)
		{
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];

			if (nr < 1 || nc < 1 || nr > n || nc > n) continue;
			if (visited[nr][nc]) continue;
			if (map[nr][nc] == 1) continue;

			visited[nr][nc] = true;
			q.push(make_pair(make_pair(nr, nc), dist + 1));
		}
	}
	return p;
}

void fail()
{
	cout << "-1\n";
	exit(0);
}

void solution()
{
	while (m-- > 0)
	{
		vector<pair<int, int>> passenger = find_Passenger();		// ½Â°´ ¹øÈ£, ÀÌµ¿ÇÑ °Å¸®
		
		if (passenger.empty())
			fail();

		int p_num = passenger.front().first;
		int dist = passenger.front().second;
		fuel -= dist;

		if (fuel <= 0)
			fail();

		int p_dist = arrive(p_num);
		if (p_dist == -1)
			fail();

		fuel -= p_dist;

		if (fuel < 0)
			fail();

		fuel += 2 * p_dist;

		taxi.first = fin[p_num].first;
		taxi.second = fin[p_num].second;
	}
	cout << fuel << "\n";
}

int main()
{
	FAST
	input();
	solution();

	return 0;
}