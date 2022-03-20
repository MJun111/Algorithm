#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int num_oper[4] = { 0 };
int arr[12];
int n;
int maxNum = -1000000000, minNum = 1000000000;

void DFS(int plus, int minus, int multiply, int divide, int cnt, int num)
{
	if (cnt == n)
	{
		maxNum = max(maxNum, num);
		minNum = min(minNum, num);
	}

	if (plus > 0)
		DFS(plus - 1, minus, multiply, divide, cnt + 1, num + arr[cnt]);

	if (minus > 0)
		DFS(plus, minus - 1, multiply, divide, cnt + 1, num - arr[cnt]);

	if (multiply > 0)
		DFS(plus, minus, multiply - 1, divide, cnt + 1, num * arr[cnt]);
	
	if (divide > 0)
		DFS(plus, minus, multiply, divide - 1, cnt + 1, num / arr[cnt]);
	
}

int main() {
	FAST

	cin >> n;

	for (int i = 0; i < n; i++)
		cin >> arr[i];

	for (int i = 0; i < 4; i++)
		cin >> num_oper[i];
	
	DFS(num_oper[0], num_oper[1], num_oper[2], num_oper[3], 1, arr[0]);

	cout << maxNum << "\n";
	cout << minNum << "\n";

	return 0;
}
