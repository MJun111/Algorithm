#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 21

int t, n;
int arr[MAX];

void solution()
{
    cin >> t;
    for (int tc = 1; tc <= t; tc++)
    {
        cin >> n;
        for (int i = 1; i <= n; i++)
            cin >> arr[i];
        
        int ans = 0;
        for (int i = 2; i < n; i++)
        {
            int maxNum = max(max(arr[i - 1], arr[i]), arr[i + 1]);
            int minNum = min(min(arr[i - 1], arr[i]), arr[i + 1]);

            if (arr[i] == maxNum || arr[i] == minNum)
                continue;
            ans++;
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