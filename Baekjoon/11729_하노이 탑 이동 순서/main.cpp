#include <iostream>
#include <cmath>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 20 + 1

int k;

void input()
{
    cin >> k;
}

void hannoi(int start, int mid, int end, int n)
{
    if (n == 1)
        cout << start << " " << end << "\n";
    else
    {
        hannoi(start, end, mid, n - 1);
        cout << start << " " << end << "\n";
        hannoi(mid, start, end, n - 1);
    }
}

void solution()
{
    cout << (int)pow(2, k) - 1 << "\n";
    hannoi(1, 2, 3, k);
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}