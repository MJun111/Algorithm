#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t;
int d[1001];

void solution()
{
    t = 10;
    for (int tc = 1; tc <= t; tc++)
    {
        int n;
        cin >> n;
        for (int i = 1; i <= n; i++)
            cin >> d[i];
        
        int ans = 0;
        for (int i = 3; i <= n - 2; i++)
        {
            int h = max(max(d[i - 2], d[i - 1]), max(d[i + 1], d[i + 2]));
            if (d[i] > h)
                ans += d[i] - h;
        }

        cout << "#" << tc << " " << ans << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}