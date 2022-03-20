#include <iostream>
#include <cmath>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int n;
bool is_prime(int num) {
	if (num == 0 || num == 1)
		return false;

	for (int i = 2; i * i <= num; i++)
		if (num % i == 0)
			return false;

	return true;
}

void calc(int num, int digit)
{
	if (digit == n)
	{
		cout << num << "\n";
		return;
	}

	for (int i = 1; i <= 9; i += 2)
	{
		if (is_prime(num * 10 + i))
			calc(num * 10 + i, digit + 1);
	}

}

int main() {
	FAST

	cin >> n;

	calc(2, 1);
	calc(3, 1);
	calc(5, 1);
	calc(7, 1);

	return 0;
}
