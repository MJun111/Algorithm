#include <iostream>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int ans[3][3] = { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };
int map[3][3];
pair<int, int> st;
int dir[4][2] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

struct _move {
    int r;
    int c;
    int cnt;
};

void input()
{
    for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++)
        {
            cin >> map[i][j];
            if (map[i][j] == 0)
                st.first = i, st.second = j;
        }
}

void BFS()
{
    queue<_move> q;
    q.push({ st.first, st.second, 0 });

    while (!q.empty())
    {
        int r = q.front().r;
        int c = q.front().c;
        int moveCnt = q.front().cnt;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if (nr < 0 || nc < 0 || nr >= 3 || nc >= 3) continue;


        }

    }
}

void solution()
{
    BFS();
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}