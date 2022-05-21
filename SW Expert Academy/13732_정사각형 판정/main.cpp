#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t, n;
char board[30][30];

void solution()
{
    cin >> t;
    int cnt = 1;
    while (t-- > 0)
    {
        cin >> n;
        for (int i = 1; i <= n; i++)
        {
            string str;
            cin >> str;
            for (int j = 1; j <= str.size(); j++)
                board[i][j] = str[j - 1];
        }

        int pos[4] = { n, n, 0, 0 };

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (board[i][j] == '#')
                {
                    pos[0] = min(pos[0], i);
                    pos[1] = min(pos[1], j);
                    pos[2] = max(pos[2], i);
                    pos[3] = max(pos[3], j);
                }

        bool ans = true;

        if ((pos[3] - pos[1]) != (pos[2] - pos[0]))
            ans = false;

        for (int i = pos[0]; i <= pos[2]; i++)
            for (int j = pos[1]; j <= pos[3]; j++)
                if (board[i][j] != '#') {
                    ans = false;
                    break;
                }

        if (ans)
            cout << "#" << cnt << " yes\n";
        else
            cout << "#" << cnt << " no\n";

        cnt++;
    }
}

int main()
{
    FAST
        solution();

    return 0;
}