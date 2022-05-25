#include <iostream>
#include <string>
#include <vector>
#include <map>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t;
void solution()
{
    cin >> t;
    for (int tc = 1; tc <= t; tc++)
    {
        string str;
        map<char, int> m;
        cin >> str;
        for (int i = 0; i < str.size(); i++)
        {
            if (m.find(str[i]) != m.end())
                m[str[i]]++;
            else
                m[str[i]] = 1;
        }
        bool check = true;
        
        if (m.size() != 2)
            check = false;
        
        for (auto iter : m)
            if (iter.second != 2)
                check = false;
        
        cout << "#" << tc << " ";
        if (check)
            cout << "Yes\n";
        else
            cout << "No\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}