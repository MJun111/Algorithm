#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t, n;
char v[100][100];

void solution()
{
    t = 10;
    for (int tc = 1; tc <= t; tc++)
    {
        int ans = 1;
        cin >> n;
        for (int i = 0; i < 100; i++)
            for (int j = 0; j < 100; j++)
                cin >> v[i][j];

        for (int i = 0; i < 100; i++)
            for (int j = 0; j < 100; j++)
            {
                int start = j;
                int end = 99;
                int loop = 1;
                int length = end;
                while (1)
                {
                    if (ans > length - j + 1)
                        break;
                    if (v[i][start] == v[i][end])
                    {
                        start++;
                        end--;
                    }
                    else
                    {
                        start = j;
                        end = 99 - loop;
                        length = end;
                        loop++;
                    }
                    if (start >= end)
                    {
                        ans = max(ans, length - j + 1);
                    }
                }
                start = j;
                end = 99;
                length = end;
                loop = 1;
                while (1)
                {
                    if(ans > length - j + 1)
                        break;
                    if (v[start][i] == v[end][i])
                    {
                        start++;
                        end--;
                    }
                    else
                    {
                        start = j;
                        end = 99 - loop;
                        length = end;
                        loop++;
                    }
                    if (start >= end)
                    {
                        ans = max(ans, length - j + 1);
                    }
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