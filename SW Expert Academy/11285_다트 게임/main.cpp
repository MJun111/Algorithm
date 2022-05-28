#include <iostream>
#include <cmath>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t, n;

int getScore(double r)
{
    int sc = 0;
    for (int p = 1; p <= 10; p++)
    {
        if (r <= (double)20 * (11 - p))
        {
            sc = p;
        }
    }
    return sc;
}

void solution()
{
    cin >> t;
    for (int tc = 1; tc <= t; tc++)
    {
        int x, y;
        double r;
        long long score = 0;
        cin >> n;
        for (int i = 0; i < n; i++)
        {
            cin >> x >> y;
            r = sqrt(pow(x, 2) + pow(y, 2));
            score += getScore(r);
        }
        cout << "#" << tc << " " << score << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}