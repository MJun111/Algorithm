#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

vector<vector<int>> map;
bool visited[26][26];
int n;
int dx[4] = { -1, 0, 1, 0, };		// 왼, 0, 오, 0
int dy[4] = { 0, -1, 0, 1, };		// 0, 아래, 0, 위

void DFS(int x, int y, int& cnt)
{
	if (visited[x][y])				// 방문 했던 곳은 패스
		return;
	else if (map[x][y] == 1)		// 방문 안했고, 아파트가 있으면 카운트			
	{
		cnt++;
		visited[x][y] = true;
	}
	else							// 아파트가 없는 곳도 패스 (map[x][y] == 0)
		return;

	for (int i = 0; i < 4; i++)		// 상하좌우 갈 수 있는 방향 모두 조사
	{
		int rx = x + dx[i];
		int ry = y + dy[i];

		if (rx >= 0 && rx <= n - 1 && ry >= 0 && ry <= n - 1)
			DFS(rx, ry, cnt);
	}
}

void solution()
{
	int d = 0;		// 단지 수
	int count = 0;	// 단지 내 아파트 수
	priority_queue<int, vector<int>, greater<int>> ans;		// 우선순위 큐에 단지 내 아파트 수 오름차순 저장

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (map[i][j] == 1 && visited[i][j] == false)	// 아파트가 있고(map[i][j] == 1), 아직 방문하지 않았다면 새로운 단지
			{
				DFS(i, j, count);
					d++;
					ans.push(count);
				
				count = 0;
			}
		}
	}

	cout << d << "\n";
	
	while (!ans.empty())
	{
		int tmp = ans.top();
		ans.pop();
		cout << tmp << "\n";
	}

}

void input()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		vector<int> vec;
		for (int j = 0; j < n; j++)
		{
			int tmp;
			scanf("%1d", &tmp);			// 연속된 정수 한 글자 씩 입력
			vec.push_back(tmp);
		}
		map.push_back(vec);
	}
}

int main()
{
	input();
	solution();
	
	return 0;
}
