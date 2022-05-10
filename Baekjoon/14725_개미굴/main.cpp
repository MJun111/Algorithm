#include <iostream>
#include <string>
#include <set>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int n, k;
set<string> s;

void input()
{
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> k;
        string tmp;
        string str;
        for (int j = 0; j < k; j++)
        {
            cin >> tmp;
            str += "*" + tmp;
            s.insert(str);
        }
    }
}

void solution()
{
    for (auto x : s)
    {
        int cnt = count(x.begin(), x.end(), '*');
        int pos = x.find_last_of("*");
        string tmp = x.substr(pos + 1);
        for (int i = 0; i < cnt - 1; i++)
            cout << "--";
        cout << tmp << "\n";
    }
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}