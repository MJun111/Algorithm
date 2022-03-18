#include <iostream>
#include <map>
using namespace std;

#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int main() {
	FAST
	int n, count = -1;
	long long num, max;
	map<long long, int> m;

	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> num;
		if (m.count(num))		// #1
			m[num]++;
		else				// #2
			m.insert(pair<long long, int>(num, 1));
	}
	
	for (auto iter = m.begin(); iter != m.end(); iter++)
	{
		if (iter->second > count)
		{
			max = iter->first;
			count = iter->second;
		}
	}

	cout << max << "\n";

	return 0;
}
