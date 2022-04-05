#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000 + 1

int n, ans;
int arr[MAX];
int Front[MAX];          // 앞에서부터 증가하는 부분수열
int Back[MAX];           // 뒤에서부터 증가하는 부분수열

void input()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
        cin >> arr[i];
}

void solution()
{
    // 앞에서 부터 탐색
    for (int i = 1; i <= n; i++)
    {
        Front[i] = 1;

        for (int j = 1; j < i; j++)
        {
            if (arr[j] < arr[i] && Front[i] < Front[j] + 1)
                Front[i] = Front[j] + 1;
        }
    }

    // 뒤에서 부터 탐색
    for (int i = n; i >= 1; i--)
    {
        Back[i] = 1;

        for (int j = n; j > i; j--)
        {
            if (arr[i] > arr[j] && Back[j] + 1 > Back[i])
                Back[i] = Back[j] + 1;
        }
    }

    for (int i = 1; i <= n; i++)
    {
        if (ans < Front[i] + Back[i] - 1)       // 중복 i 제외 -> -1
            ans = Front[i] + Back[i] - 1;
    }
    
    cout << ans << "\n";
}

int main(void)
{
    FAST
    input();
    solution();

    return 0;
}