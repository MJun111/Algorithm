#include <iostream>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 15

int col[MAX];   // i 번째 행에 퀸의 열 위치 (i, col[i])
int n, ans;

void input()
{
    cin >> n;
}

bool check(int row)
{
    for (int i = 0; i < row; i++)
    {
        if (col[i] == col[row] || row - i == abs(col[row] - col[i]))
            return false;
    }

    return true;
}

void nQueen(int row)
{
    if (row == n)
    {
        ans++;
        return;
    }

    for (int i = 0; i < n; i++)
    {
        col[row] = i;

        if (check(row))
            nQueen(row + 1);
    }
}

void solution()
{
    nQueen(0);
    cout << ans;
}

int main(void)
{
    FAST
    input();
    solution();

    return 0;
}