#include <iostream>
#include <cmath>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 4000000

int n, sum;
bool prime[MAX + 1];        // false : prime
vector<int> p_sum;

void input()
{
	cin >> n;
}

void getPrime()
{
	prime[0] = prime[1] = true;

	for (int i = 2; i <= sqrt(MAX); i++)
		if (!prime[i])
			for (int j = 2 * i; j <= MAX; j += i)
				prime[j] = true;

}

void solution()
{
	int cnt = 0;

	getPrime();
	
	int L = 0, R = 0, sum = 0;
	while (L <= R)		
	{
		if (R > n)
			break;

		if (sum < n)
		{
			while (prime[++R])
			{}
			sum += R;
		}
		else if (sum > n)
		{
			sum -= L;
			while (prime[++L])
			{}
		}
		else
		{
			cnt++;
			while (prime[++R])
			{}
			sum += R;
		}
	}
	
	cout << cnt << "\n";
}

int main()
{
	FAST
	input();
	solution();

	return 0;
}