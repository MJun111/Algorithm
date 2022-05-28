#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t;

void solution()
{
    cin >> t;
    for (int tc = 1; tc <= t; tc++)
    {
        long long d, l, n;
        long long dmg = 0;
        cin >> d >> l >> n;
        for (int i = 1; i <= n; i++)
            dmg += d + d * (i - 1) * l / 100;
        cout << "#" << tc << " " << dmg << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}