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
vector<pair<int, int>> fin;
int dir[4][2] = { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
bool visited[MAX][MAX];

void input()
{
	cin >> n >> m >> fuel;
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			cin >> map[i][j];
	cin >> taxi.first >> taxi.second;
	fin.push_back({ -1, -1 });			// 0번째 순서 채우기용

	for (int i = 1; i <= m; i++)
	{
		int r1, c1, r2, c2;
		cin >> r1 >> c1 >> r2 >> c2;
		map[r1][c1] = i + 1;			// i번째 승객 -> 맵에 i + 1로 표시
		fin.push_back({ r2, c2 });		// fin[i] : i번째 도착 좌표
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
		int dist = -q.top().first;
		int r = -q.top().second.first;
		int c = -q.top().second.second;
		q.pop();

		if (map[r][c] > 1)
		{
			p.push_back(make_pair(map[r][c] - 1, dist));
			taxi.first = r;
			taxi.second = c;
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
	queue<pair<int, pair<int, int>>> q;
	q.push(make_pair(0, make_pair(taxi.first, taxi.second)));
	visited[taxi.first][taxi.second] = true;

	while (!q.empty())
	{
		int dist = q.front().first;
		int r = q.front().second.first;
		int c = q.front().second.second;
		q.pop();

		if (r == fin[num].first && c == fin[num].second)
		{
			p = dist;
			taxi.first = r;
			taxi.second = c;
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
			q.push(make_pair(dist + 1, make_pair(nr, nc)));
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
		vector<pair<int, int>> passenger = find_Passenger();	
		if (passenger.empty())									// 승객 탐색 결과 찾지 못하면 종료
			fail();

		int p_num = passenger.front().first;					// 승객 번호
		int dist = passenger.front().second;					// 이동한 거리
		fuel -= dist;

		if (fuel <= 0)		// 남은연료 - 이동한 거리 <= 0 : 종료
			fail();

		int p_dist = arrive(p_num);		// 목적지까지 운행 
		if (p_dist == -1)				// 도착하지 못하면 종료
			fail();

		fuel -= p_dist;					

		if (fuel < 0)		// 남은연료 - 이동한 거리 < 0 : 종료
			fail();

		fuel += 2 * p_dist;	// 승객을 태우고 이동한 거리만큼 연료 충전
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