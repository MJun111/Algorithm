#include <iostream>
#include <algorithm>
#include <set>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100 + 1

int n;
int arr[MAX];

void input()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
        cin >> arr[i];
}

int getGcd(int a, int b)
{
    return b ? getGcd(b, a % b) : a;
}

void solution()
{
    sort(arr + 1, arr + 1 + n);

    int gcd = arr[2] - arr[1];
    
    for (int i = 2; i <= n; i++)
        gcd = getGcd(gcd, arr[i] - arr[i - 1]);

    set<int> s;
    for (int i = 1; i * i <= gcd; i++)
        if (gcd % i == 0)
        {
            s.insert(i);
            s.insert(gcd / i);
        }
    s.erase(1);
    
    for (auto ans : s)
        cout << ans << " ";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}