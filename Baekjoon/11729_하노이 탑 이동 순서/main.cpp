#include <iostream>
#include <stack>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 20 + 1

int k;
stack<int> st[3];

void input()
{
    cin >> k;
}

void solution()
{
    for (int i = k; i > 0; i--)
        st[0].push(i);

    while (k > 0)
    {
        if (k % 2 == 1)
        {
            st[2].push(st[0].top());
            st[0].pop();

            
            k--;
        }
        else
        {
            st[1].push(st[0].top());
            st[0].pop();

            while (st[0].empty())
            {

            }
            k--;
        }
    }
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}