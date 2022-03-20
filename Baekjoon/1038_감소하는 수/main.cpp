#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

const int MAX = 1000000;

int n;
queue<long long> q;
long long ans[MAX + 1];

void input()
{
    cin >> n;

    for (int i = 1; i <= 9; i++)
    {
        q.push(i);
        ans[i] = i;
    }
}

void solution()
{
    int idx = 9;

    while (idx <= n)
    {
        if (q.empty())
            return;

        long long mNum = q.front();
        q.pop();
        
        int lastNum = mNum % 10;
        
        for (int i = 0; i < lastNum; i++)
        {
            q.push(mNum * 10 + i);
            ans[++idx] = mNum * 10 + i;
        }
    }
}

void except()
{
    if (!ans[n] && n)
        cout << -1 << endl;
    else
        cout << ans[n] << endl;
}

int main(void)
{
    input();
    solution();
    except();
    
    return 0;
}
