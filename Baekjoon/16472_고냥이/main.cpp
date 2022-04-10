#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int n, kind;
string s;
int cnt[26];

void input()
{   
    cin >> n;
    cin >> s;
}

void Add(char x)
{
    cnt[x - 'a']++;
    
    if (cnt[x - 'a'] == 1)
        kind++;
}

void Erase(char x)
{
    cnt[x - 'a']--;
    
    if (cnt[x - 'a'] == 0)
        kind--;
}

void solution()
{
    int L = 0, R = 0;
    int ans = 0;

    while (R < s.size())
    {
        Add(s[R]);

        while (kind > n)
            Erase(s[L++]);

        ans = max(ans, R - L + 1);
        R++;
    }
    cout << ans << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}