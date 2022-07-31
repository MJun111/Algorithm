#include <iostream>
#include <string>
#include <queue>
#include <set>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

string str;
string goal = "123456780";
set<string> visited;
int dir[4][2] = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

void input()
{
    for (int i = 0; i < 9; i++)
    {
        char c;
        cin >> c;
        str += c;
    }
}

int BFS()
{
    queue<pair<string, int>> q;
    q.push({ str, 0 });

    while (!q.empty())
    {
        string cur = q.front().first;
        int cnt = q.front().second;
        q.pop();
        
        if (cur == goal)
            return cnt;

        int zero = cur.find('0');
        int r = zero / 3;
        int c = zero % 3;

        for (int i = 0; i < 4; i++)
        {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if (nr < 0 || nc < 0 || nr >= 3 || nc >= 3) continue;
            
            string next = cur;
            swap(next[3 * r + c], next[3 * nr + nc]);
            if (visited.find(next) == visited.end())
            {
                visited.insert(next);
                q.push({ next, cnt + 1 });
            }
        }
    }
    return -1;
}

void solution()
{
    cout << BFS() << "\n";


}

int main()
{
    FAST
    input();
    solution();

    return 0;
}