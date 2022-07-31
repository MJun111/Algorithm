#include <iostream>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000000000

int n, m;
vector<int> vec;

void input()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        vec.push_back(x);
    }
}

bool determination(int k)
{
    int money = k;
    int cnt = 1;

    for (int i = 0; i < n; i++)
    {
        // 한 번 인출하는 양이 하루 쓸 돈보다 적으면 모순
        if (k < vec[i])
            return false;

        if (money - vec[i] >= 0)
        {
            money -= vec[i];
        }
        else
        {
            cnt++;
            money = k - vec[i];
        }
    }

    return cnt <= m;
}

void solution()
{
    int L = 1, R = MAX, ans = 0;

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