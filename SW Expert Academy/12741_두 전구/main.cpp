#include <iostream>
#include <cstring>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t;

void solution()
{
    cin >> t;
    for (int tc = 1; tc <= t; tc++)
    {
        int a, b, c, d;
        cin >> a >> b >> c >> d;
        bool x[101], y[101];
        memset(x, false, sizeof(x));
        memset(y, false, sizeof(y));
        for (int i = a; i <= b; i++)
            x[i] = true;
        for (int i = c; i <= d; i++)
            y[i] = true;

        int cnt = 0;
        for (int i = 0; i <= 100; i++)
            if (x[i] && y[i])
                cnt++;

        if (cnt == 0)
            cnt = 1;
        cout << "#" << tc << " " << cnt - 1 << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}