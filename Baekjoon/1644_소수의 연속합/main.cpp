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

	/*
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
	*/
	p_sum.push_back(0);		// ?
	for (int i = 2; i <= MAX; i++)
		if (!prime[i])
		{
			sum += i;
			p_sum.push_back(sum);
		}
	
	int left, right;
	cnt = 0;
	left = 0;
	right = 0;

	while (left <= right && right < p_sum.size())
	{
		if (p_sum[right] - p_sum[left] > n)
		{
			left++;
		}
		else if (p_sum[right] - p_sum[left] < n)
		{
			right++;
		}
		else // (p_sum[right] - p_sum[left] == N)
		{
			cnt++;
			right++;
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