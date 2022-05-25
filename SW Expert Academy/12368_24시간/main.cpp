#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t;

void solution()
{
    cin >> t;
    for (int tc = 1; tc <= t; tc++)
    {
        int a, b;
        cin >> a >> b;
        cout << "#" << tc << " " << (a + b) % 24 << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}