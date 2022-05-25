#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t, n;

void solution()
{
    cin >> t;
    for (int tc = 1; tc <= t; tc++)
    {
        cin >> n;
        bool check = false;
        
        int tmp;
        for (int i = 1; i < 10; i++)
            if (n % i == 0 && n / i < 10)
            {
                check = true;
                break;
            }
        

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