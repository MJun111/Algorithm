#include <iostream>
#include <string>
#include <deque>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int n, k;
string s;

void input()
{
	cin >> n >> k;
	cin >> s;
}

void solution()
{
	deque<char> dq;

	for (int i = 0; i < s.length(); i++)
	{
		while (k && !dq.empty() && dq.back() < s[i])
		{
			dq.pop_back();
			k--;
		}
		dq.push_back(s[i]);
	}

	for (int i = 0; i < dq.size() - k; i++)
		cout << dq[i];

}

int main()
{
	FAST
	input();
	solution();

	return 0;
}