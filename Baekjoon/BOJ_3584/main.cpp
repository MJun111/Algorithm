#include <iostream>
#include <vector>
#include <cstring>
#include <map>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 10000 + 1

int t, n, x1, x2, root;
int parent[MAX];
map<int, int> m;

void input()
{
    int a, b;
    cin >> n;
    for (int i = 0; i < n - 1; i++)
    {
        cin >> a >> b;
        parent[b] = a;
    }
    cin >> x1 >> x2;
}

void findRoot()
{
    for (int i = 1; i <= n; i++)
        if (parent[i] == 0)
            root = i;
}

void getAnscenstor(vector<int>& NCA)
{
    int tmp = x1;
    while (1)
    {
        NCA.push_back(tmp);
        m[tmp]++;
        if (tmp == root)
            break;
        tmp = parent[tmp];
    }

    tmp = x2;
    while (1)
    {
        m[tmp]++;
        if (tmp == root)
            break;
        tmp = parent[tmp];
    }
}

int getNCA(vector<int>& NCA)
{
    for (int i = 0; i < NCA.size(); i++)
        if (m[NCA[i]] == 2)
            return NCA[i];
    
    return -1;
}

void solution()
{
    cin >> t;
    while (t-- > 0)
    {
        memset(parent, 0, sizeof(parent));
        m.clear();
        
        input();
        findRoot();

        vector<int> NCA;
        getAnscenstor(NCA);
        cout << getNCA(NCA) << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}