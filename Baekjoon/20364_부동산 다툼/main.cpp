#include <iostream>
#include <vector>
#include <stack>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1048576 + 1

int n, q;
int arr[MAX];
bool visited[MAX];

void input()
{
    cin >> n >> q;
    for (int i = 1; i <= q; i++)
        cin >> arr[i];
}

void solution()
{
    for (int i = 1; i <= q; i++)
    {
        int tmp = arr[i];
        stack<int> st;
        
        while (tmp > 0)
        {
            st.push(tmp);
            tmp /= 2;
        }

        bool check = true;
        while (!st.empty())
        {
            tmp = st.top();
            st.pop();
            if (visited[tmp])
            {
                cout << tmp << "\n";
                check = false;
                break;
            }
        }
        if (check)
        {
            visited[arr[i]] = true;
            cout << "0\n";
        }
    }
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}