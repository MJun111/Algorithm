#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int n;
vector<string> file;

void input()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		string str;
		cin >> str;

		str.erase(0, str.find('.') + 1);
		
		file.push_back(str);
	}
}

void solution()
{
	vector<pair<string, int>> ans;
	int cnt = 1;

	sort(file.begin(), file.end());

	for (int i = 1; i < file.size(); i++)
	{
		if (file[i - 1] == file[i])
			cnt++;
		else
		{
			ans.push_back({ file[i - 1], cnt });
			cnt = 1;
		}
	}

	ans.push_back({ file[file.size() - 1], cnt });

	for (int i = 0; i < ans.size(); i++)
		cout << ans[i].first << " " << ans[i].second << "\n";

}

int main() {
	FAST
	input();
	solution();
	return 0;
}