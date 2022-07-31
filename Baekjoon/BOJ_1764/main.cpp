#include <iostream>
#include <string>
#include <map>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int n, m;
int cnt = 0;
map<string, int> dbj;

void input()
{
    cin >> n >> m;
    string tmp;
    
    for (int i = 0; i < n; i++)
    {
        cin >> tmp;
        if (dbj[tmp] == 0)
            dbj[tmp]++;
    }
    
    for (int j = 0; j < m; j++)
    {
        cin >> tmp;
        if (dbj[tmp] == 1)
        {
            dbj[tmp]++;
            cnt++;
        }
    }
}

void solution()
{
    cout << cnt << "\n";
    for (auto iter = dbj.begin(); iter != dbj.end(); iter++)
    {
        if (iter->second == 2)
            cout << iter->first << "\n";
    }
}

int main(void)
{
    FAST
    input();
    solution();

    return 0;
}