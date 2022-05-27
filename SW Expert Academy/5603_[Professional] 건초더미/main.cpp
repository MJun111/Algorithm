#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t;
int s[10001];

void solution()
{
    cin >> t;
    for (int tc = 1; tc <= t; tc++)
    {
        int n, avg, max = 0, ans = 0;
        cin >> n;
        for (int i = 0; i < n; i++)
        {
            cin >> s[i];
            max += s[i];
        }
        avg = max / n;

        for (int i = 0; i < n; i++)
        {
            if (s[i] > avg)
                ans += s[i] - avg;
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