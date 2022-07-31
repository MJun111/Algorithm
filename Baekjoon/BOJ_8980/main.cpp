#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 2000 + 1

class Delivery
{
public:
	int from;
	int to;
	int count;

	Delivery(int f, int t, int cnt)
	{
		from = f;
		to = t;
		count = cnt;
	}
};

int n, c, m, ans;
vector<Delivery> d;
int capacity[MAX];	// ���� �뷮

void input()
{
	cin >> n >> c;
	cin >> m;
	for (int i = 0; i < m; i++)
	{
		int from, to, cnt;
		cin >> from >> to >> cnt;
		d.push_back(Delivery(from, to, cnt));
	}
}

bool comp(Delivery a, Delivery b)
{
	if (a.to < b.to)
		return true;

	return false;
}

void solution()
{
	sort(d.begin(), d.end(), comp);		// ������ �������� ����
	
	for (int i = 0; i < m; i++)
	{
		int cap = 0;
		
		for (int j = d[i].from; j < d[i].to; j++)	// ��� �� ����뷮 ���� ū �κ� ����
			cap = max(cap, capacity[j]);
		
		int box = min(d[i].count, c - cap);			// �ѵ� �̳��� ��� ����, �ƴϸ� ���� �� ��ŭ�� ����
		ans += box;

		for (int j = d[i].from; j < d[i].to; j++)	// ���� �뷮 �߰�
			capacity[j] += box;
	}
	cout << ans << "\n";
}

int main()
{
	FAST
	input();
	solution();

	return 0;
}