#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 10000 + 1

int n, m;
int arr[MAX];

void input()
{
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
        cin >> arr[i];
    
}

void solution()
{
    int start = 1, end = 1;
    int cnt = 0;
    int sum = arr[1];

    while (end <= n)
    {
        if (sum <= m)
        {
            if (sum == m)
                cnt++;

            sum += arr[++end];
        }
        else
        {
            sum -= arr[start++];

            if (start > end)
            {
                end = start;
                sum = arr[start];
            }
        }
    }
    cout << cnt << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}