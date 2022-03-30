#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int main()
{
	FAST

	int t, n, m;
	cin >> t;
	
	while(t-- > 0)
	{
		cin >> n >> m;

		vector<int> a, b;
		int cnt = 0;
		int tmp;

		for (int i = 0; i < n; i++)
		{
			cin >> tmp;
			a.push_back(tmp);
		}

		for (int i = 0; i < m; i++)
		{
			cin >> tmp;
			b.push_back(tmp);
		}

		sort(b.begin(), b.end());

		for (int i = 0; i < n; i++)
		{
			int L = 0;
			int R = m - 1;
			int res = 0;

			while (!(L > R))
			{
				int M = (L + R) / 2;

				if (a[i] > b[M])
				{
					res = M + 1;	// b[0] -> res : 1 
					L = M + 1;
				}
				else
				{
					R = M - 1;
				}
			}

			cnt += res;
		}
		cout << cnt << "\n";
	}

	return 0;
}