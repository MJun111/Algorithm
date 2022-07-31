#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000 + 1

int t, k, m, p;
vector<int> arr[MAX];           // a -> b
int degree[MAX];                // ���� ���� ��
pair<int, int> ans[MAX];        // ���(����, ����)

void Initialization(int m)
{
    for (int i = 1; i <= m; i++)
    {
        arr[i].clear();
        degree[i] = 0;
        ans[i] = pair<int, int>(0, 0);
    }
}

void Input(int p)
{
    for (int i = 1; i <= p; i++)
    {
        int a, b;
        cin >> a >> b;
        arr[a].push_back(b);
        degree[b]++;
    }
}

void solution()
{
    cin >> t;

    while (t--)
    {
        cin >> k >> m >> p;

        Initialization(m);
        Input(p);
        
        queue<int> q;

        for (int i = 1; i <= m; i++)
            if (degree[i] == 0)     // ���� �ٿ���
            {
                q.push(i);
                ans[i] = pair<int, int>(1, 1);
            }


        while(!q.empty())
        {
            int curr = q.front();
            q.pop();

            for (int next : arr[curr]) {    // curr -> next 
                if (ans[next].first < ans[curr].first)
                    ans[next] = pair<int, int>(ans[curr].first, 1);
                else if (ans[next].first == ans[curr].first)
                    ans[next].second++;

                degree[next]--;
                if (degree[next] == 0)
                {
                    if (ans[next].second > 1)
                        ans[next] = pair<int, int>(ans[next].first + 1, 1);
                    
                    q.push(next);
                }
            }
        }

        int cor = 0;

        for (int i = 1; i <= m; i++)
            cor = max(cor, ans[i].first);

        cout << k << " " << cor << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}