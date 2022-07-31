#include <iostream>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int n;
vector<vector<int>> home;
int state = 0;  // 0 : 가로, 1 : 세로, 2 : 대각선
int ans = 0;

void input()
{
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        vector<int> tmp;
        for (int i = 0; i < n; i++)
        {
            int x;
            cin >> x;
            tmp.push_back(x);
        }
        home.push_back(tmp);
    }
}

void DFS(int r, int c, int state)
{
    if (r >= n || c >= n)
        return;
    if (home[r][c] == 1)
        return;
    if (state == 2 && (home[r - 1][c] == 1 || home[r][c - 1] == 1))
        return;

    if (r == n - 1 && c == n - 1) 
    {
        ans++;
        return;
    }

    switch (state)
    {
    case 0: 
        DFS(r, c + 1, 0);
        DFS(r + 1, c + 1, 2);
        break;
    case 1:
        DFS(r + 1, c, 1);
        DFS(r + 1, c + 1, 2);
        break;
    case 2:
        DFS(r, c + 1, 0);
        DFS(r + 1, c, 1);
        DFS(r + 1, c + 1, 2);
        break;
    }
}

void solution()
{
    int r = 0, c = 1;
    DFS(r, c, state);
    cout << ans << "\n";
}

int main()
{
    input();
    solution();

    return 0;
}
