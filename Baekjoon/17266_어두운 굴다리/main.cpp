#include <iostream>
#include <cstring>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int n, m;
int light[MAX];

void input()
{
    cin >> n >> m;
    for (int i = 0; i < m; i++)
        cin >> light[i];
}

bool determination(int M)
{
    // 0 ~ light[0] 구간
    if (light[0] > M)
        return false;

    // light[0] ~ light[m-1] 구간
    for (int i = 0; i < m - 1; i++)
    {
        int midDis = light[i + 1] - light[i];
        if (midDis > 2 * M)
            return false;
    }

    // light[m-1] ~ n 구간
    if (n - light[m - 1] > M)
        return false;

    return true;
}

void solution()
{
    int L = 0, R = 2 * MAX, ans = 0;

    while (L <= R)
    {
        int M = (L + R) / 2;
        if (determination(M))
        {
            ans = M;
            R = M - 1;
        }
        else
        {
            L = M + 1;
        }
    }

    cout << ans << "\n";
}

int main(void)
{
    FAST
    input();
    solution();

    return 0;
}