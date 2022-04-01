#include <iostream>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int n, m;
vector<int> tree;

void input()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        int t;
        cin >> t;
        tree.push_back(t);
    }
}

// h 높이로 나무를 자를 때, m만큼 얻을 수 있는지
bool determination(int h)
{
    long long sum = 0;
    for (int i = 0; i < n; i++)
    {
        if (tree[i] > h)
            sum += tree[i] - h;
    }
    return sum >= m;
}

void solution()
{
    long L = 1, R = 2000000000;
    long ans = 0;
       
    while (L <= R)
    {
        int mid = (L + R) / 2;
        if (determination(mid))
        {
            ans = mid;
            L = mid + 1;
        }
        else
        {
            R = mid - 1;
        }
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