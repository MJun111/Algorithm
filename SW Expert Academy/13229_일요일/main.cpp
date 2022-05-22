#include <iostream>
#include <string>
#include <map>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t;
map<string, int> m;

void input()
{
    m["SAT"] = 1;
    m["FRI"] = 2;
    m["THU"] = 3;
    m["WED"] = 4;
    m["TUE"] = 5;
    m["MON"] = 6;
    m["SUN"] = 7;
}

void solution()
{
    cin >> t;
    for (int i = 1; i <= t; i++)
    {
        string str;
        cin >> str;
        cout << "#" << i << " " << m[str] << "\n";
    }
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}