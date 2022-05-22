#include <iostream>
#include <cmath>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t, n, d;

void solution()
{
    cin >> t;
    for (int i = 1; i <= t; i++)
    {
        cin >> n >> d;
        int range = 2 * d + 1;
        int ans = ceil((double)n / range);
        cout << "#" << i << " " << ans << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}