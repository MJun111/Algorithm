#include <iostream>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 200 + 1

int Limits[3];
bool possible[MAX];
bool visited[MAX][MAX][MAX];

struct State
{
    int X[3];
    State(int* _X)
    {
        for (int i = 0; i < 3; i++)
            X[i] = _X[i];
    }

    State move(int from, int to, int* Limit)
    {
        int nX[3] = { X[0], X[1], X[2] };
        if (X[from] + X[to] >= Limit[to]) {
            nX[from] -= (Limit[to] - X[to]);
            nX[to] = Limit[to];
        }
        else
        {
            nX[to] += X[from];
            nX[from] = 0;
        }

        return State(nX);
    }
};

void input()
{
    for (int i = 0; i < 3; i++)
        cin >> Limits[i];
}

void BFS(int x1, int x2, int x3)
{
    visited[x1][x2][x3] = true;

    queue<State> q;
    q.push(State(new int[] {x1, x2, x3}));

    while (!q.empty())
    {
        State st = q.front();
        q.pop();

        if (st.X[0] == 0)
            possible[st.X[2]] = true;
        
        for (int from = 0; from < 3; from++)
        {
            for (int to = 0; to < 3; to++)
            {
                if (from == to)
                    continue;

                State nxt = st.move(from, to, Limits);
                if (!visited[nxt.X[0]][nxt.X[1]][nxt.X[2]])
                {
                    visited[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                    q.push(nxt);
                }
            }
        }
    }
}

void solution()
{
    BFS(0, 0, Limits[2]);

    for (int i = 0; i <= Limits[2]; i++)
        if (possible[i])
            cout << i << " ";

}

int main()
{
    FAST
    input();
    solution();

    return 0;
}