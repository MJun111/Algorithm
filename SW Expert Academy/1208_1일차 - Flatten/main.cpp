#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t;
int h[101];

void solution()
{
    t = 10;
    for (int tc = 1; tc <= t; tc++)
    {
        int n;
        priority_queue<int> maxQ, minQ;
        cin >> n;
        for (int i = 1; i <= 100; i++)
        {
            cin >> h[i];
            maxQ.push(h[i]);
            minQ.push(-h[i]);
        }
        for (int i = 1; i <= n; i++)
        {
            int maxH = maxQ.top();
            int minH = -minQ.top();
            maxQ.pop();
            minQ.pop();
            maxQ.push(maxH - 1);
            minQ.push(-(minH + 1));
        }
        cout << "#" << tc << " " << maxQ.top() + minQ.top() << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}