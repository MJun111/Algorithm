#include <iostream>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int n;
int A[MAX];
bool cnt[MAX];      // 해당 원소가 중복인지 체크하는 배열

void input()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
        cin >> A[i];
}

void solution()
{
    long long ans = 0;
    int L = 1, R = 1;

    while (R <= n)
    {
        int val = A[R];
        while (cnt[val])
        {
            ans += (long long)R - L;
            cout << ans << "\n";
            cnt[A[L++]] = false;
        }
        cnt[val] = true;
        R++;
    }

    ans += (long long)(R - L) * (R - L + 1) / 2;
    cout << ans << "\n";
}

int main(void)
{
    FAST
    input();
    solution();

    return 0;
}