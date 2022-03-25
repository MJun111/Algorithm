#include <iostream>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1001

int s;
int arr[MAX][MAX];		// arr[screen][clip] = 걸리는 시간, 0 일시 방문 안했다는 것

int BFS(int n)
{
	int ans = -1;

	queue<pair<int, int>> q;
	q.push({ n, 0 });		// screen = 1, clip = 0

	while (!q.empty())
	{
		int sc = q.front().first;
		int cl = q.front().second;
		q.pop();

		if (sc == s)
		{
			return arr[sc][cl];
		}

		if (arr[sc][sc] == 0)		// 복사
		{
			q.push({ sc, sc });
			arr[sc][sc] = arr[sc][cl] + 1;
		}
		if (sc + cl <= s && arr[sc + cl][cl] == 0)	// 붙여넣기
		{
			q.push({ sc + cl, cl });
			arr[sc + cl][cl] = arr[sc][cl] + 1;
		}
		if (sc - 1 > 0 && arr[sc - 1][cl] == 0)		// 하나 삭제
		{
			q.push({ sc - 1, cl });
			arr[sc - 1][cl] = arr[sc][cl] + 1;
		}
	}

	/*
	for (int i = 0; i <= s; i++)
	{
		if (arr[s][i] != 0)
			if (ans == -1 || ans > arr[s][i])
				ans = arr[s][i];
	}
	*/
	return ans;
}

void input()
{
	cin >> s;
}

void solution()
{
	cout << BFS(1);
}

int main()
{
	FAST
	input();
	solution();
	return 0;
}