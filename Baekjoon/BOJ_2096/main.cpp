#include <iostream>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int n;
int dpMax[3], dpMin[3];

void input()
{
    cin >> n;
}

void solution()
{
    cin >> dpMax[0] >> dpMax[1] >> dpMax[2];
    for (int i = 0; i < 3; i++)
        dpMin[i] = dpMax[i];
    
    int input[3];
    for (int i = 2; i <= n; i++)
    {
        cin >> input[0] >> input[1] >> input[2];
        int tmp1 = dpMax[0];
        int tmp2 = dpMax[2];
        dpMax[0] = max(dpMax[0], dpMax[1]) + input[0];
        dpMax[2] = max(dpMax[1], dpMax[2]) + input[2];
        dpMax[1] = max(max(tmp1, tmp2), dpMax[1]) + input[1];

        tmp1 = dpMin[0];
        tmp2 = dpMin[2];
        dpMin[0] = min(dpMin[0], dpMin[1]) + input[0];
        dpMin[2] = min(dpMin[1], dpMin[2]) + input[2];
        dpMin[1] = min(min(tmp1, tmp2), dpMin[1]) + input[1];
    }
    cout << max(max(dpMax[0], dpMax[1]), dpMax[2]) << " " << min(min(dpMin[0], dpMin[1]), dpMin[2]);
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}