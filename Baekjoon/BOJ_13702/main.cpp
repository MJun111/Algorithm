#include <iostream>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int n, k;
vector<long long> vec;
long long maxL = 0;
void input()
{
    cin >> n >> k;
    for (int i = 0; i < n; i++)
    {
        long long x;
        cin >> x;
        if (x > maxL)
            maxL = x;
        vec.push_back(x);
    }
}

int determination(long long M)
{
    int cnt = 0;
    
    for (int i = 0; i < n; i++)
    {
        cnt += vec[i] / M;
    }
    return cnt >= k;
}

void solution()
{
    long long L = 1, R = maxL, ans = 0;

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