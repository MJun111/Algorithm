#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t, n;
char table[8][8];

void solution()
{
    t = 10;
    for (int tc = 1; tc <= t; tc++)
    {
        cin >> n;
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                cin >> table[i][j];

        if (n == 1)
        {
            cout << "#" << tc << "64\n";
            continue;
        }

        int ans = 0;
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (j + n - 1 >= 8)
                    break;

                bool row = true;
                bool col = true;
                int start = j;
                int end = j + n - 1;
                while (1)
                {
                    if (start >= end) break;
                    if (table[i][start] != table[i][end])
                    {
                        row = false;
                        break;
                    }
                    start++;
                    end--;
                }
                start = j;
                end = j + n - 1;
                while (1)
                {
                    if (start >= end) break;
                    if (table[start][i] != table[end][i])
                    {
                        col = false;
                        break;
                    }
                    start++;
                    end--;
                }
                if (row)
                    ans++;
                if (col)
                    ans++;
            }
        }
        cout << "#" << tc << " " << ans << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}