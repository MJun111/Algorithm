#include <iostream>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int ans[3][3] = { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };
int map[3][3];
pair<int, int> st;
int dir[4][2] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

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
    queue<pair<int, int>> q;

    q.push({ st.first, st.second });

    while (!q.empty())
    {


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