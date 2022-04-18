#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 10000 + 1

int tree[MAX];
int n = 0;

void input()
{
	int num;
	while (cin >> num)			// ·çÆ®, ¿Ş, ¿À
		tree[n++] = num;
}

void postorder(int start, int end)
{
	if (start >= end)
		return;

	int i;
	for (i = start + 1; i < end; i++)
		if (tree[start] < tree[i])
			break;

	postorder(start + 1, i);			// ¿ŞÂÊ ¼­ºêÆ®¸® Å½»ö
	postorder(i, end);					// ¿À¸¥ÂÊ ¼­ºêÆ®¸® Å½»ö
	cout << tree[start] << "\n";		// ·çÆ®
}

void solution()
{
	postorder(0, n);
}

int main()
{
	FAST
	input();
	solution();

	return 0;
}