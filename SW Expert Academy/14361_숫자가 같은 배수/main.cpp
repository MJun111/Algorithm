#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t, n;
string str;

void solution()
{
    cin >> t;
    for (int tc = 1; tc <= t; tc++)
    {
        cin >> n;
        str = to_string(n);

        bool ans = false;
        while (next_permutation(str.begin(), str.end()))
        {
            int re = stoi(str);
            if (re > n)
            {
                if (re % n == 0)
                    ans = true;
            }
        }

        cout << "#" << tc << " ";
        
        if (ans)
            cout << "possible\n";
        else
            cout << "impossible\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}