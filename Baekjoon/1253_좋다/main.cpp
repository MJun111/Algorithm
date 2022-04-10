#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 2000 + 1

int n;
int A[MAX];

void input()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
        cin >> A[i];
}

bool func(int target_idx)
{
    int L = 1, R = n;
    int target = A[target_idx];

    while (L < R)
    {
        if (L == target_idx)
            L++;
        else if (R == target_idx)
            R--;
        else
        {
            if (A[L] + A[R] == target)
                return true;
            if (A[L] + A[R] > target)
                R--;
            else
                L++;
        }
    }

    return false;
}

void solution()
{
    int ans = 0;
    sort(A + 1, A + n + 1);

    for (int i = 1; i <= n; i++)
    {
        if (func(i))
            ans++;
    }
    cout << ans << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}