#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 20 + 1

int n;
int fibo[MAX];

void input()
{
    cin >> n;
}

void solution()
{
    fibo[0] = 0;
    fibo[1] = 1;
    
    for (int i = 2; i <= n; i++)
        fibo[i] = fibo[i - 2] + fibo[i - 1];

    cout << fibo[n] << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}