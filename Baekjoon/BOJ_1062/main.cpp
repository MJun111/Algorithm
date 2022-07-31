#include <iostream>
#include <string>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int n, k, ans = 0;
string word[51];
bool alpha[26];

// anta ~~~ tica : a, n, t, i, c -> 5
void DFS(char c, int cnt)
{
	if (cnt == k - 5)		// 배울 수 있는 알파벳이 최대일 때
	{
		int read = 0;		// 읽을 수 있는 단어 수
		for (int i = 0; i < n; i++)
		{
			bool check = true;
			for (int j = 0; j < word[i].size(); j++)
			{
				if (!alpha[word[i][j] - 'a'])
				{
					check = false;
					break;
				}
			}
			if (check)
				read++;
		}
		ans = max(ans, read);
	}

	for (int i = c; i < 26; i++)
	{
		if (!alpha[i])
		{
			alpha[i] = true;
			DFS(i, cnt + 1);
			alpha[i] = false;
		}
	}
}

void isDone(int k)
{
	if (k < 5)
	{
		cout << "0\n";
		exit(0);
	}

	if (k == 26)
	{
		cout << n << "\n";
		exit(0);
	}
}

int main() {
	FAST
	cin >> n >> k;
	cin.ignore();

	isDone(k);

	for (int i = 0; i < n; i++)
	{
		getline(cin, word[i]);
		word[i].erase(word[i].begin(), word[i].begin() + 4);
		word[i].erase(word[i].end() - 4, word[i].end());		
	}

	alpha['a' - 'a'] = true;
	alpha['n' - 'a'] = true;
	alpha['t' - 'a'] = true;
	alpha['i' - 'a'] = true;
	alpha['c' - 'a'] = true;

	DFS(0, 0);

	cout << ans << "\n";

	return 0;
}
