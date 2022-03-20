#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int gcd(int a, int b)
{
	return b ? gcd(b, a % b) : a;
}

int main() {
	FAST
	int a, b;
	int n1, n2;
	
	cin >> a >> b;
	
	n1 = gcd(a, b);
	n2 = a * b / n1;
	
	cout << n1 << "\n" << n2;

	return 0;
}
