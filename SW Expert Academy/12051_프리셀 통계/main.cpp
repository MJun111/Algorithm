#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

long long n, d, g;
int t, pd, pg;

void solution()
{
    cin >> t;
    for (int tc = 1; tc <= t; tc++)
    {
        cin >> n >> pd >> pg;
        bool ans = true;

        if ((pd < 100 && pg == 100) || (pd > 0 && pg == 0))
            ans = false;

        if (ans)
        {
            for (long long i = 1; i <= n; i++)
            {
                if ((i * (double)pd / 100) - (i * pd / 100) == 0)
                {
                    ans = true;
                    break;
                }
                ans = false;
            }
        }

        cout << "#" << tc << " ";
        if (ans)
            cout << "Possible\n";
        else
            cout << "Broken\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}