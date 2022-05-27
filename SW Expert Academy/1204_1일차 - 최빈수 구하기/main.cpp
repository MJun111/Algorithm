#include <iostream>
#include <map>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t;

void solution()
{
    cin >> t;
    for (int tc = 1; tc <= t; tc++)
    {
        int tmp;
        cin >> tmp;
        map<int, int> m;
        for (int i = 0; i < 1000; i++)
        {
            int score;
            cin >> score;
            m[score]++;
        }
        int ans = 0;
        int cnt = 0;
        for (auto iter = m.begin(); iter != m.end(); iter++)
        {
            if (iter->second >= cnt)
            {
                ans = iter->first;
                cnt = iter->second;
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