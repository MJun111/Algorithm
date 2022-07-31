#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int n;
vector<vector<int>> board;
int check[21][21];          // 합쳐진 칸인지 판별
int ans;
void DFS(vector<vector<int>> board, int cnt);
void UP(vector<vector<int>> board, int cnt);
void DOWN(vector<vector<int>> board, int cnt);
void LEFT(vector<vector<int>> board, int cnt);
void RIGHT(vector<vector<int>> board, int cnt);

void input()
{
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        vector<int> tmp;
        for (int j = 0; j < n; j++)
        {
            int num;
            cin >> num;
            tmp.push_back(num);
        }
        board.push_back(tmp);
    }
}

void solution()
{
    DFS(board, 0);

    cout << ans << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}

void DFS(vector<vector<int>> board, int cnt)
{

    if (cnt == 5)
    {
        // 보드 내 가장 큰 수 return
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 0) continue;
                if (board[i][j] >= ans)
                    ans = board[i][j];
            }
        return;
    }

    UP(board, cnt);
    DOWN(board, cnt);
    LEFT(board, cnt);
    RIGHT(board, cnt);
}

void UP(vector<vector<int>> board, int cnt)
{
    memset(check, false, sizeof(check));

    for (int i = 1; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (board[i][j] == 0) continue;
            int r = i;
            while (1)
            {
                if (r == 0)
                {
                    board[0][j] = board[i][j];
                    board[i][j] = 0;
                    break;
                }

                if (board[r - 1][j] == 0) r--;
                else if (board[r - 1][j] == board[i][j] && !check[r - 1][j])
                {
                    check[r - 1][j] = true;
                    board[r - 1][j] *= 2;
                    board[i][j] = 0;
                    break;
                }
                else
                {
                    board[r][j] = board[i][j];
                    if (r != i)         // 기존 자리에서 움직인 경우
                        board[i][j] = 0;
                    break;
                }
            }
        }
    }
    DFS(board, cnt + 1);
}

void DOWN(vector<vector<int>> board, int cnt)
{
    memset(check, false, sizeof(check));

    for (int i = n - 2; i >= 0; i--)
    {
        for (int j = 0; j < n; j++)
        {
            if (board[i][j] == 0) continue;
            int r = i;
            while (1)
            {
                if (r == n - 1)
                {
                    board[n - 1][j] = board[i][j];
                    board[i][j] = 0;
                    break;
                }

                if (board[r + 1][j] == 0) r++;
                else if (board[r + 1][j] == board[i][j] && !check[r + 1][j])
                {
                    check[r + 1][j] = true;
                    board[r + 1][j] *= 2;
                    board[i][j] = 0;
                    break;
                }
                else
                {
                    board[r][j] = board[i][j];
                    if (r != i)
                        board[i][j] = 0;
                    break;
                }
            }
        }
    }
    DFS(board, cnt + 1);
}

void LEFT(vector<vector<int>> board, int cnt)
{
    memset(check, false, sizeof(check));

    for (int i = 0; i < n; i++)
    {
        for (int j = 1; j < n; j++)
        {
            if (board[i][j] == 0) continue;
            int c = j;
            while (1)
            {
                if (c == 0)
                {
                    board[i][0] = board[i][j];
                    board[i][j] = 0;
                    break;
                }

                if (board[i][c - 1] == 0) c--;
                else if (board[i][c - 1] == board[i][j] && !check[i][c - 1])
                {
                    check[i][c - 1] = true;
                    board[i][c - 1] *= 2;
                    board[i][j] = 0;
                    break;
                }
                else
                {
                    board[i][c] = board[i][j];
                    if (c != j)         // 기존 자리에서 움직인 경우
                        board[i][j] = 0;
                    break;
                }
            }
        }
    }
    DFS(board, cnt + 1);
}

void RIGHT(vector<vector<int>> board, int cnt)
{
    memset(check, false, sizeof(check));

    for (int i = 0; i < n; i++)
    {
        for (int j = n - 2; j >= 0; j--)
        {
            if (board[i][j] == 0) continue;
            int c = j;
            while (1)
            {
                if (c == n - 1)
                {
                    board[i][n - 1] = board[i][j];
                    board[i][j] = 0;
                    break;
                }

                if (board[i][c + 1] == 0) c++;
                else if (board[i][c + 1] == board[i][j] && !check[i][c + 1])
                {
                    check[i][c + 1] = true;
                    board[i][c + 1] *= 2;
                    board[i][j] = 0;
                    break;
                }
                else
                {
                    board[i][c] = board[i][j];
                    if (c != j)         // 기존 자리에서 움직인 경우
                        board[i][j] = 0;
                    break;
                }
            }
        }
    }
    DFS(board, cnt + 1);
}
