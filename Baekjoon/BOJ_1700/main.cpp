#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int main() {
	FAST
	int n, k, num;
	int ans = 0;
	vector<int> multitab;
	vector<int> schedule;

	cin >> n >> k;
	
	for (int i = 0; i < k; i++)
	{
		cin >> num;
		schedule.push_back(num);
	}

	for (int i = 0; i < k; i++)
	{
		// #1
		if (find(multitab.begin(), multitab.end(), schedule[i]) != multitab.end())
			continue;

		// #2
		if (multitab.size() < n) 
			multitab.push_back(schedule[i]);
		// #3
		else
		{
			int need = -1;
			int index = -1;

			for (int j = 0; j < n; j++)
			{
				int tmp = 0;

				for (int m = i + 1; m < k; m++)
				{
					if (schedule[m] == multitab[j])
						break;
					
					tmp++;
				}

				if (tmp > need)
				{
					need = tmp;
					index = j;
				}
			}

			multitab[index] = schedule[i];
			ans++;
		}
	}

	cout << ans << "\n";

	return 0;
}
