#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t, n;
int arr[100][100];

void solution()
{
    t = 10;
    for (int tc = 1; tc <= t; tc++)
    {
        int num;
        int cross[2] = { 0, 0 };
        int maxSum = INT_MIN;
        cin >> num;

        for (int i = 0; i < 100; i++)
            for (int j = 0; j < 100; j++)
                cin >> arr[i][j];

        int cross1 = 0;
        int cross2 = 0;
        for (int i = 0; i < 100; i++)
        {
            int sum_r = 0;
            int sum_c = 0;
            for (int j = 0; j < 100; j++)
            {
                sum_r += arr[i][j];
                sum_c += arr[j][i];

                if (i == j)
                    cross1 += arr[i][j];
                if (i + j == 99)
                    cross2 += arr[i][j];
            }
            maxSum = max(max(sum_r, sum_c), maxSum);
        }
        maxSum = max(max(cross1, cross2), maxSum);

        cout << "#" << tc << " " << maxSum << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}