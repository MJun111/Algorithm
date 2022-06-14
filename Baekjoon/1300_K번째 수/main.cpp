#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int n, k;

void input()
{
    cin >> n >> k;
}

void solution()
{
    int L = 1, R = k;
    int ans = 0;

    while (L <= R)
    {
        int mid = (L + R) / 2;
        int cnt = 0;

        for (int i = 1; i <= n; i++)
            cnt += min(mid / i, n);

        if (cnt < k)
            L = mid + 1;
        else
        {
            ans = mid;
            R = mid - 1;
        }
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