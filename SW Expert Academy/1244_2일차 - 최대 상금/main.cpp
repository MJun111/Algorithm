#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t, n, ans;
string str;

void DFS(int idx, int cnt)
{
	if (cnt == n)
	{
		ans = max(ans, stoi(str));
		return;
	}

	for (int i = idx; i < str.size() - 1; i++)
		for (int j = i + 1; j < str.size(); j++)
		{
			swap(str[i], str[j]);
			DFS(i, cnt + 1);
			swap(str[i], str[j]);
		}
}

void solution()
{
	cin >> t;
	for (int tc = 1; tc <= t; tc++)
	{
		cin >> str >> n;
		ans = 0;
		if (n > str.size())
			n = str.size() - 1;
		DFS(0, 0);

		cout << "#" << tc << " " << ans << "\n";
	}
}

int main()
{
	FAST
		solution();

	return 0;
}