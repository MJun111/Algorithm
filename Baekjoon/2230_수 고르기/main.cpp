#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int n, m;
int arr[MAX];

void input()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++)
        cin >> arr[i];
}

void solution()
{
    int start = 0, end = 1;
    int ans = 2000000000 + 1;
    sort(arr, arr + n);

    while (end < n)
    {
        int num = arr[end] - arr[start];

        if (num >= m)
        {
            ans = min(ans, num);
            start++;
        }
        else
        {
            end++;
        }

        if (start > end)
        {
            start = end++;
        }
    }

    cout << ans << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}