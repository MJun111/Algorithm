#include <iostream>
#include <vector>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int n, m, k;
vector<int> arr[MAX];
int inDeg[MAX];
int built[MAX];

void input()
{
    cin >> n >> m >> k;
    for (int i = 1; i <= m; i++)
    {
        int a, b;
        cin >> a >> b;
        arr[a].push_back(b);
        inDeg[b]++;
    }
}

void solution()
{
    bool check = true;

    for (int i = 1; i <= k; i++)
    {
        int a, b;
        cin >> a >> b;

        if (a == 1)
        {
            if (inDeg[b] == 0)
            {
                built[b]++;
                if (built[b] == 1)
                {
                    for (int next : arr[b])
                        inDeg[next]--;
                }
                
            }
            else
            {
                check = false;
                break;
            }
        }
        else
        {
            if (built[b] > 0)
            {
                built[b]--;
                if (built[b] == 0)
                {
                    for (int next : arr[b])
                        inDeg[next]++;
                }
            }
            else
            {
                check = false;
                break;
            }
        }
    }

    if (check)
        cout << "King-God-Emperor\n";
    else
        cout << "Lier!\n";

}

int main()
{
    FAST
    input();
    solution();

    return 0;
}