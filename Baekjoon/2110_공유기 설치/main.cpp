#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000000000

int n, c;
vector<int> map;

void input()
{
    cin >> n >> c;
    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        map.push_back(x);
    }
    sort(map.begin(), map.end());
}

bool determination(int d)
{
    int cnt = 1;
    int num = map[0];
    for (int i = 1; i < n; i++)
    {
        if (map[i] - num >= d)
        {
            cnt++;
            num = map[i];
        }
    }
    return cnt >= c;
}

void solution()
{
    int L = 0, R = MAX, ans = 0;

    while (L <= R)
    {
        int M = (L + R) / 2;

        if (determination(M))
        {
            ans = M;
            L = M + 1;
        }
        else
        {
            R = M - 1;
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