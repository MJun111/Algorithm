#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t, n;

void solution()
{
	cin >> t;
	for (int tc = 1; tc <= t; tc++)
	{
		cin >> n;
		cout << "#" << tc << " ";
		for (int i = 1; i < n; i++)
			cout << 1 << "/" << n << " ";
		cout << 1 << "/" << n << "\n";
	}
}

int main()
{
	FAST
	solution();

	return 0;
}