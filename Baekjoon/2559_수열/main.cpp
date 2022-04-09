#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int n, k;
int arr[MAX];
void input()
{
    cin >> n >> k;
    for (int i = 1; i <= n; i++)
        cin >> arr[i];
}

void solution()
{
    int L = 1, R = 1;
    int sum = arr[1];
    int max = -987654321;
    while (R <= n)
    {
        int day = R - L + 1;
        if (day < k)
        {
            sum += arr[++R];
        }
        else if (day > k)
        {
            sum -= arr[L++];
            if (L > R)
            {
                R = L;
                sum = arr[R];
            }
        }
        else
        {
            if (max < sum)
                max = sum;

            sum += arr[++R];
        }
    }
    cout << max << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}