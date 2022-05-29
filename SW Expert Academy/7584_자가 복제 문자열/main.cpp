#include <iostream>
#include <string>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t;
long long k;

void solution()
{
    cin >> t;
    for (int tc = 1; tc <= t; tc++)
    {
        cin >> k;
        k--;
        int check = 0;
        while (k >= 0)
        {
            if (k % 2 == 1)
                k = (k - 1) / 2;
            else if (k % 4 == 0)
            {
                check = 0;
                break;
            }
            else if (k % 2 == 0)
            {
                check = 1;
                break;
            }
        }

        cout << "#" << tc << " " << check << "\n" ;
    }
}

int main()
{
    FAST
    solution();

    return 0;
}