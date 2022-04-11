#include <iostream>
#include <cstring>
#include <vector>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 500 + 1

int t, n, m;
int priority[MAX][MAX];         // 등수 간 우선 순위
int last[MAX];                  // 작년 순위
int inDegree[MAX];              // 진입 차수


void clear_arr()
{
    memset(priority, 0, sizeof(priority));
    memset(last, 0, sizeof(last));
    memset(inDegree, 0, sizeof(inDegree));
}

void solution()
{
    cin >> t;

    while (t--)
    {
        clear_arr();
        cin >> n;

        // 작년 순위
        for (int i = 1; i <= n; i++)
            cin >> last[i];

        // 작년 기준 등수 간 우선 순위, 진입 차수
        for (int i = 1; i <= n; i++)
        {
            for (int j = i + 1; j <= n; j++)
            {
                priority[last[i]][last[j]] = 1;
                inDegree[last[j]]++;
            }
        }

        // 우선 순위 방향 변경, 진입 차수 변경
        cin >> m;
        for (int i = 1; i <= m; i++)
        {
            int a, b;
            cin >> a >> b;

            if (priority[a][b])
            {
                priority[a][b] = 0;
                priority[b][a] = 1;
                inDegree[a]++;
                inDegree[b]--;
            }
            else
            {
                priority[a][b] = 1;
                priority[b][a] = 0;
                inDegree[a]--;
                inDegree[b]++;
            }
        }

        queue<int> q;

        // 진입 차수가 낮은 것 부터 큐에 삽입(1등)
        for (int i = 1; i <= n; i++)
        {
            if (!inDegree[i])
                q.push(i);
        }

        vector<int> ans;
        bool check = false;
        while (!q.empty())
        {
            // 큐에 두 개씩 들어가면 진입 차수가 같은 것 존재 -> 확실한 순위를 알 수 없음
            if (q.size() > 1)
            {
                check = true;
                break;
            }

            int cur = q.front();
            q.pop(); 
            ans.push_back(cur);

            // 현재 순위보다 낮은 순위의 진입차수 - 1 
            for (int i = 1; i <= n; i++)
            {
                if (priority[cur][i])
                {
                    inDegree[i]--;
                    if (!inDegree[i])
                        q.push(i);
                }
            }
        }

        if (check)
            cout << "?\n";
        else if (ans.size() == n)
        {
            for (auto a : ans)
                cout << a << " ";

            cout << "\n";
        }
        else
            cout << "IMPOSSIBLE\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}