#include <iostream>
#include <string>
#include <map>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t;
map<char, int> m;

void set_map()
{
    string g1 = "CEFGHIJKLMNSTUVWXYZ";
    string g2 = "ADOPQR";
    string g3 = "B";

    for (char c : g1) m[c] = 0;
    for (char c : g2) m[c] = 1;
    for (char c : g3) m[c] = 2;
}

void solution()
{
    set_map();
    cin >> t;
    for (int tc = 1; tc <= t; tc++)
    {
        string str[2];
        cin >> str[0] >> str[1];

        bool ans = str[0].size() == str[1].size();
        
        if (ans)
        {
            for (int i = 0; i < str[0].size(); i++)
                if (m[str[0][i]] != m[str[1][i]])
                    ans = false;
        }

        cout << "#" << tc << " " << (ans ? "SAME\n" : "DIFF\n");
    }
}

int main()
{
    FAST
    solution();

    return 0;
}