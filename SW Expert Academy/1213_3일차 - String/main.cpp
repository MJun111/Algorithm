#include <iostream>
#include <string>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t;

void solution()
{
    t = 10;
    for (int tc = 1; tc <= t; tc++)
    {
        int n;
        cin >> n;
        string search, str;
        cin >> search;
        cin >> str;
        
        int cnt = 0;
        while (str.find(search) != string::npos)
		{
            str = str.substr(str.find(search) + search.size(), str.size() - str.find(search) - search.size());
			cnt++;
		}
        cout << "#" << tc << " " << cnt << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}