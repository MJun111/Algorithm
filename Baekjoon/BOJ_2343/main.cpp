#include <iostream>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int n, m;
int longTime = 0;
vector<int> vec;

void input()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        vec.push_back(x);
        longTime = x > longTime ? x : longTime;
    }
}

bool determination(int d)
{
    int sum = 0;
    int cnt = 1;

    for (int i = 0; i < n; i++)
    {
        if (sum + vec[i] <= d)
        {
            sum += vec[i];
        }
        else
        {
            sum = vec[i];
            cnt++;
        }
    }
   
    return cnt <= m;
}

void solution()
{
    int L = longTime, R = 1000000000, ans = 0;

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