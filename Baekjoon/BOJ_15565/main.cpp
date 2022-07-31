#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000000 + 1

int n, k;
int arr[MAX];
vector<int> pos;

void input()
{
    int doll;
    cin >> n >> k;
    for (int i = 1; i <= n; i++)
    {
        cin >> doll;
        if (doll == 1)
            pos.push_back(i);
    }
}

void solution()
{
    int size = MAX;

    if (pos.size() < k)
    {
        cout << "-1" << "\n";
        return;
    }

    for (int i = 0; i <= pos.size() - k; i++)
        size = min(size, pos[i + k - 1] - pos[i] + 1);
    
    cout << size << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}