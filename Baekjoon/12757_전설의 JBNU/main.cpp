#include <iostream>
#include <map>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int n, m, k;
map<int, int> DB;    

void input()
{
    cin >> n >> m >> k;
    for (int i = 0; i < n; i++)
    {
        int a, b;
        cin >> a >> b;
        DB[a] = b;
    }
}

int findKey(int num)
{
    if (DB.lower_bound(num) == DB.begin())
    {
        if (DB.lower_bound(num)->first - num <= k)
            return DB.lower_bound(num)->first;
        else
            return -1;
    }
    else if (DB.lower_bound(num) == DB.end())
    {
        if (num - (--DB.lower_bound(num))->first <= k)
            return (--DB.lower_bound(num))->first;
        else
            return -1;
    }
    else
    {
        int prev = num - (--DB.lower_bound(num))->first;
        int next = DB.lower_bound(num)->first - num;

        if (prev == next)
            return -2;
        else if (prev < next)
        {
            if (prev <= k)
                return (--DB.lower_bound(num))->first;
            else
                return -1;
        }
        else
        {
            if (next <= k)
                return DB.lower_bound(num)->first;
            else
                return -1;
        }
    }
    return 0;
}

void solution()
{

    for (int i = 0; i < m; i++)
    {
        int order, a, b;
        cin >> order;
        if (order == 1)
        {
            cin >> a >> b;
            DB[a] = b;
        }
        else if (order == 2)
        {
            cin >> a >> b;
            int val = findKey(a);
            if (val == -2 || val == -1) 
                continue;
            else
            {
                DB.erase(val);
                DB[val] = b;
            }
        }
        else
        {
            cin >> a;
            int val = findKey(a);
            if (val == -1)
                cout << "-1\n";
            else if (val == -2)
                cout << "?\n";
            else
                cout << DB[val] << "\n";
        }
    }
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}