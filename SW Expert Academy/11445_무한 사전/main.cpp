#include <iostream>
#include <string>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t;

void solution()
{
    cin >> t;
    for (int tc = 1; tc <= t; tc++)
    {
        string p, q;
        bool ans = true;
        cin >> p >> q;
        if (q == p + 'a')
            ans = false;

        cout << "#" << tc << " " ;
        if (ans)
            cout << "Y\n";
        else
            cout << "N\n";
    }
}

int main()
{
    FAST
        solution();

    return 0;
}