#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 16

int L, C;
char pw[MAX];
bool used[MAX];
string str = "";

void input()
{
    cin >> L >> C;
    for (int i = 0; i < C; i++)
        cin >> pw[i];
}

bool check()
{
    int cnt = 0;
    for (int i = 0; i < L; i++)
        if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u')
            cnt++;

    if (cnt >= 1 && L - cnt >= 2)
        return true;

    return false;
}

void make_pw(int st, int cnt)
{
    if (cnt == L)
    {
        if (check())
            cout << str << "\n";
        
        return;
    }

    for (int i = st; i < C; i++)
    {
        if (!used[i])
        {
            used[i] = true;
            str += pw[i];
            make_pw(i, cnt + 1);
            used[i] = false;
            str.pop_back();
        }
    }
}

void solution()
{
    sort(pw, pw + C);
    make_pw(0, 0);
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}