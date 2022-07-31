#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 21
#define INF 987654321

int n, m;
int ans = INF;
int CX1, CY1, CX2, CY2;         // ���� ��ǥ
char board[MAX][MAX];           
int dy[4] = { 1, 0, -1, 0 };
int dx[4] = { 0, 1, 0, -1 };

void input()
{
    bool check = true;

    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> board[i][j];
            if (board[i][j] == 'o' && check)
            {
                CX1 = j;
                CY1 = i;
                check = false;
            }
            else if (board[i][j] == 'o' && !check)
            {
                CX2 = j;
                CY2 = i;
            }
        }
    }
}

bool checkRange(int x, int y)               // ���� ������ �������� ���� üũ
{
    if (x >= 0 && y >= 0 && x < m && y < n)
        return true;
    else
        return false;
}

void DFS(int cx1, int cy1, int cx2, int cy2, int cnt)
{
    if (cnt == 10)
        return;
    
    // �� ���� �� ���� �̵�
    for (int i = 0; i < 4; i++)
    {
        int rx1 = cx1 + dx[i];
        int rx2 = cx2 + dx[i];
        int ry1 = cy1 + dy[i];
        int ry2 = cy2 + dy[i];

        if (checkRange(rx1, ry1) && checkRange(rx2, ry2))           // �̵� ����(����)�� ������ ���� ��
        {
            if (board[ry1][rx1] == '#' && board[ry2][rx2] == '#')   // �� ���� ��ΰ� ���� ������ ����X
                continue;
            if (board[ry1][rx1] == '#')                             // �� ������ ���� ������ �̵� ���� ����
                rx1 = cx1, ry1 = cy1;
            if (board[ry2][rx2] == '#')
                rx2 = cx2, ry2 = cy2;

            DFS(rx1, ry1, rx2, ry2, cnt + 1);
        }
        else if (checkRange(rx1, ry1) != checkRange(rx2, ry2))      // ���� �ϳ��� ���� ������ ���� ���
        {
            if (ans > cnt + 1)                                      // �̵� Ƚ���� �������� ���ٸ� ���� (�̵� ���ĸ� �������� ���� ������ cnt + 1)
                ans = cnt + 1;
            return;
        }
    }
}

void solution()
{
    DFS(CX1, CY1, CX2, CY2, 0);
    
    if (ans == INF)
        ans = -1;

    cout << ans << "\n";
}

int main(void)
{
    FAST
    input();
    solution();

    return 0;
}