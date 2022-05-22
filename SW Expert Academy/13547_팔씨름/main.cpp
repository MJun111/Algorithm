#include <iostream>
#include <string>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t;

void solution()
{
    cin >> t;
    for (int i = 1; i <= t; i++)
    {
        int cnt = 0;
        string str;
        cin >> str;
        for (int j = 0; j < str.size(); j++)
        {
            if (str[j] == 'o')
                cnt++;
        }
        int leftGames = 15 - str.size();

        cout << "#" << i;
        if (cnt + leftGames >= 8)
            cout << " YES\n";
        else
            cout << " NO\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}