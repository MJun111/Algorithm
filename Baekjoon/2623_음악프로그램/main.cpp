#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000 + 1

int n, m;
vector<int> arr[MAX];
int inDeg[MAX];
vector<int> ans;

void input()
{
    int s;
    cin >> n >> m;
    while (m-- > 0)
    {
        cin >> s;
        int tmp1, tmp2;
        for (int i = 0; i < s; i++)
        {
            cin >> tmp1;
            if (i == 0)
            {
                tmp2 = tmp1;
                continue;
            }
            arr[tmp2].push_back(tmp1);
            inDeg[tmp1]++;
            tmp2 = tmp1;
        }
    }
}

void solution()
{
    queue<int> q;
    bool check = true;
    for (int i = 1; i <= n; i++)
        if (inDeg[i] == 0)
            q.push(i);

    while (!q.empty())
    {
        int singer = q.front();
        q.pop();
        ans.push_back(singer);
        
        for (int next : arr[singer])
        {
            inDeg[next]--;
            if (inDeg[next] == 0)
                q.push(next);
        }
    }

    for (int i = 1; i <= n; i++)
        if (inDeg[i] != 0)
            check = false;

    if (check)
        for (auto x : ans)
            cout << x << "\n";

    else
        cout << "0\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}