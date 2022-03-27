#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int n, m;
vector<vector<int>> space;
queue<pair<int, int>> q;
int dr[8] = { -1, -1, 0, 1, 1, 1, 0, -1};
int dc[8] = { 0, 1, 1, 1, 0, -1, -1, -1};

void input()
{
    cin >> n >> m;

    for (int i = 0; i < n; i++)
    {
        vector<int> vec;
        for (int j = 0; j < m; j++)
        {
            int a;
            cin >> a;
            vec.push_back(a);       // 공간 space

            if (a)                  // 상어 좌표 큐에 삽임
                q.push({ i, j });
        }
        space.push_back(vec);
    }
}

bool checkRange(int r, int c)
{
    if (r < n && r >= 0 && c < m && c >= 0)
        return true;
    
    return false;
}

void BFS()
{
    while (!q.empty())
    {
        int r = q.front().first;
        int c = q.front().second;
        q.pop();

        for (int i = 0; i < 8; i++)
        {
            int rr = r + dr[i];
            int cc = c + dc[i];
            if (checkRange(rr, cc) && !space[rr][cc])       // 큐에서 이동한 위치가 빈칸인 경우
            {
                q.push({ rr, cc });                         // 해당 좌표에 안전 거리 기록
                space[rr][cc] = space[r][c] + 1;            
            }
        }
    }
}

void solution()
{
    int ans = 0;

    BFS();

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            ans = space[i][j] > ans ? space[i][j] : ans;

    cout << ans - 1 << "\n";
}

int main(void)
{
    FAST
    input();
    solution();

    return 0;
}
