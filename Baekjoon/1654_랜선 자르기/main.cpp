#include <iostream>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000000

int k, n;
long long maxLan = 0;
vector<long long> vec;

void input()
{
    cin >> k >> n;
    for (int i = 0; i < k; i++)
    {
        long long x;
        cin >> x;
        vec.push_back(x);
        if (maxLan < x)
            maxLan = x;
    }
}

bool determination(long long d)
{
    int cnt = 0;

    for (int i = 0; i < k; i++)
    {
        cnt += vec[i] / d;
    }
    return cnt >= n;
}

void solution()
{
    long long L = 1, R = maxLan, ans = 0;

    while (L <= R)
    {
        long long M = (L + R) / 2;
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