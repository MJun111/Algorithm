#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000000 + 1
// (S[i] - S[j]) % m == 0 -> S[i] % m == S[j] % m

int n, m;
long long arr[MAX], S[MAX], cnt[MAX], ans;

void input()
{
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
        cin >> arr[i];
}

void solution()
{
    for (int i = 1; i <= n; i++)
    {
        S[i] = S[i - 1] + arr[i];
        cnt[S[i] % m]++;

        if (S[i] % m == 0)
            ans++;
    }

    for (int i = 0; i < m; i++)
        ans += cnt[i] * (cnt[i] - 1) / 2;

    cout << ans << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}