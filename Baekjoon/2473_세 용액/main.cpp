#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define SIZE 5000 + 1

int n;
int A[SIZE];
int idx[3];

void input()
{
    cin >> n;
    for (int i = 0; i < n; i++)
        cin >> A[i];
}

void solution()
{
    long long val = llabs(LLONG_MAX);
    sort(A, A + n);

    for (int i = 0; i < n - 1; i++)
    {
        int L = i + 1, R = n - 1;
        while (L < R)
        {
            long long sum = (long long)A[i] + A[L] + A[R];

            if (llabs(sum) < val)
            {
                val = llabs(sum);
                idx[0] = i;
                idx[1] = L;
                idx[2] = R;
            }

            if (sum < 0)
                L++;
            else
                R--;
        }
    }
    cout << A[idx[0]] << " " << A[idx[1]] << " " << A[idx[2]] << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}