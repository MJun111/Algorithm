#include <iostream>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100 + 1

int n;
int arr[MAX][MAX];
bool visited[MAX][MAX];

void input()
{
    cin >> n;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            cin >> arr[i][j];
}

void BFS(int x)
{
    queue<int> q;
    q.push(x);

    while (!q.empty())
    {
        int node = q.front();
        q.pop();

        for (int i = 0; i < n; i++)
            if (arr[node][i] && !visited[x][i])
            {
                visited[x][i] = true;
                q.push(i);
            }
    }

}

void Floyd()
{
    for (int k = 0; k < n; k++)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (arr[i][k] && arr[k][j])
                    arr[i][j] = 1;
}

void solution()
{
    //BFS
    for (int i = 0; i < n; i++)
        BFS(i);

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
            cout << visited[i][j] << " ";
        cout << "\n";
    }

    /*
    // Floyd
    Floyd();
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
            cout << arr[i][j] << " ";
        cout << "\n";
    }
    */
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}
