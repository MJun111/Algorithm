#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

char board[51][51];
int n;

int nCandy()
{
    int res = 1;			// 연속된 길이의 최대값

    for (int i = 0; i < n; i++)
    {
        int horizontal = 1;		// 가로 연속 비교
        int vertical = 1;		// 세로 연속 비교

        for (int j = 1; j < n; j++)
        {
            if (board[i][j - 1] == board[i][j])
                horizontal++;
            else
                horizontal = 1;

            if (board[j - 1][i] == board[j][i])
                vertical++;
            else
                vertical = 1;

            res = max(res, max(horizontal, vertical));
        }
    }

    return res;
}

void swapCandy()
{
    int res = 0;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n - 1; j++)
        {
            swap(board[i][j], board[i][j + 1]);		// 가로 교환
            res = max(res, nCandy());
            swap(board[i][j], board[i][j + 1]);

            swap(board[j][i], board[j + 1][i]);		// 세로 교환
            res = max(res, nCandy());
            swap(board[j][i], board[j + 1][i]);
        }
    }
    cout << res << "\n";
}

void input()
{
    cin >> n;

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            cin >> board[i][j];
}

int main() {
    FAST

    input();
    swapCandy();

    return 0;
}
