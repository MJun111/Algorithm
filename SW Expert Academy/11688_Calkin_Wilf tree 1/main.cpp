#include <iostream>
#include <string>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t;

int get_gcd(int a, int b)
{
    int c;
    while (b != 0)
    {
        c = a % b;
        a = b;
        b = c;
    }
    return a;
}

void solution()
{
    cin >> t;
    for (int tc = 1; tc <= t; tc++)
    {
        string order;
        cin >> order;
        int x = 1, y = 1;       // x : 분자, y : 분모 -> x / y
        for (int i = 0; i < order.size(); i++)
        {
            if (order[i] == 'L')
                y += x;
            else
                x += y;
        }
        int gcd = get_gcd(x, y);
        x /= gcd;
        y /= gcd;

        cout << "#" << tc << " " << x << " " << y << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}