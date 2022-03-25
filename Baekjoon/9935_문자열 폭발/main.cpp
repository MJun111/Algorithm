#include <iostream>
#include <string>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000001

string s, bomb;
char ans[MAX];

void input()
{
	cin >> s;
	cin >> bomb;
}

void solution()
{
	int idx = 0;

	for (int i = 0; i < s.size(); i++)
	{
		ans[idx++] = s[i];

		if (ans[idx - 1] == bomb[bomb.size() - 1])
		{
			if (idx < bomb.size())
				continue;

			bool check = true;
			for (int j = 0; j < bomb.size(); j++)
			{
				if (ans[idx - j - 1] != bomb[bomb.size() - j - 1])
				{
					check = false;
					break;
				}
			}

			if (check)
				idx -= bomb.size();
		}
	}

	if (!idx)
		cout << "FRULA\n";
	else
		for (int i = 0; i < idx; i++)
			cout << ans[i];
	cout << "\n";
}
int main(void)
{
	FAST
		input();
	solution();
	return 0;
}
