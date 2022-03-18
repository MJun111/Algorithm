#include <iostream>
#include <vector>
using namespace std;

#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int main() {
	FAST
	int h, w, left, right;
	int result = 0;
	int ans = 0;

	cin >> h >> w;
	vector<int> block(w);

	for (int i = 0; i < w; i++)
	{
		cin >> block[i];
	}

	for (int i = 1; i < w - 1; i++)
	{
		left = 0;
		right = 0;

		for (int j = 0; j < i; j++)			// 왼쪽 기둥 최댓값
		{
			left = max(block[j], left);
		}

		for (int j = i + 1; j < w; j++)		// 오른쪽 기둥 최댓값
		{
			right = max(block[j], right);
		}

		result = max(0,min(left, right) - block[i]);	// 기둥 최댓 값 중 낮은 값 선택, result가 0보다 작은 경우 0으로 선택
		ans += result;
	}

	cout << ans << "\n";

	return 0;
}
