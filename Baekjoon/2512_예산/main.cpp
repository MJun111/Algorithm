#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000000000

int n, m, sum;
vector<int> vec;
bool check;

void input()
{
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        vec.push_back(x);
        sum += x;
    }
    cin >> m;
    sort(vec.begin(), vec.end());
}

bool determination(int d)
{
    int num = 0;

    for (int i = 0; i < n; i++)
    {
        if (vec[i] >= d)
        {
            check = true;
            num += d;
        }
        else
            num += vec[i];
    }

    return num <= m;
}

void solution()
{
    int L = 1, R = 100000, ans = 0;
    
    while (L <= R)
    {
        int M = (L + R) / 2;
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

    // 배정된 예산들이 임의의 상수보다 크지 않을 때 가장 큰 값을 리턴
    if (!check)
        ans = vec[vec.size() - 1];

    cout << ans;
}

int main(void)
{
    FAST
    input();
    solution();

    return 0;
}