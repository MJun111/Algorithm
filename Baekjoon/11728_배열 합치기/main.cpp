#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000000 + 1

int n, m;
vector<int> C;

void input()
{
    cin >> n >> m;
    for (int i = 0; i < n + m; i++)
    {
        int num;
        cin >> num;
        C.push_back(num);
    }
}

void solution()
{
    sort(C.begin(), C.end());

    for (auto c : C)
        cout << c << " ";

}

int main()
{
    FAST
    input();
    solution();

    return 0;
}