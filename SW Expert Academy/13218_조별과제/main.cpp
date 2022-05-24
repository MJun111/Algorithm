#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t, n;

void solution()
{
    cin >> t;
    for (int i = 1; i <= t; i++)
    {
        cin >> n;
        cout << "#" << i << " " << n / 3 << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}