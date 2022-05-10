#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100 + 1

bool visited[MAX];

int BFS(vector<int>* node, int k)
{
    int cnt = 1;
    queue<int> q;
    q.push(k);

    while (!q.empty())
    {
        int num = q.front();
        q.pop();

        for (int i = 0; i < node[num].size(); i++)
        {
            if (!visited[node[num][i]])
            {
                visited[node[num][i]] = true;
                q.push(node[num][i]);
                cnt++;
            }
        }
    }

    return cnt;
}

int solution(int n, vector<vector<int>> wires) {
    int answer = MAX;

    for (int i = 0; i < n - 1; i++)
    {
        memset(visited, false, sizeof(visited));
        vector<int> node[MAX];
        for (int j = 0; j < n - 1; j++)
        {
            if (i == j) continue;

            node[wires[j][0]].push_back(wires[j][1]);
            node[wires[j][1]].push_back(wires[j][0]);
        }

        int tmp[2] = { 0, 0 };
        int t = 0;

        for (int k = 1; k <= n; k++)
        {
            if (!visited[k])
            {
                visited[k] = true;
                tmp[t++] = BFS(node, k);
            }
        }

        answer = min(answer, abs(tmp[1] - tmp[0]));
    }

    return answer;
}

int main()
{
    FAST
    int n = 9; 
    vector<vector<int>> wires = { {1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9} };
    cout << solution(n, wires);

    return 0;
}