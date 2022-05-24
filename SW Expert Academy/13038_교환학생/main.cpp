#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t, n;
int a[7];

int have_day(int num)
{
    int day = 1;
    int cnt = 1;

    while (1)
    {
        if (cnt == n)
            break;
        num = (num + 1) % 7;
        if (a[num] == 1)
            cnt++;
        day++;
    }
    return day;
}

void solution()
{
    cin >> t;
    for (int i = 1; i <= t; i++)
    {
        cin >> n;
        for (int j = 0; j < 7; j++)
            cin >> a[j];

        int ans = 987654321;
        for (int j = 0; j < 7; j++)
            if (a[j] == 1)
                ans = min(ans, have_day(j));

        cout << "#" << i << " " << ans << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}