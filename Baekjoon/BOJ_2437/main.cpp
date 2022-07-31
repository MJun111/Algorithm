#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int n;
int w[1001];

void input()
{
    cin >> n;
    for (int i = 0; i < n; i++)
        cin >> w[i];
}

void solution()
{
    sort(w, w + n);
    int sum = 0;

    for (int i = 0; i < n; i++)
    {
        if (w[i] >= sum + 2) break;
        sum += w[i];
    }

    cout << sum + 1 << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}