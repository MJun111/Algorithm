#include <iostream>
#include <vector>
#include <map>
#include <cstring>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000 + 1

int n, k;
int arr[MAX];
vector<int> depth[MAX];
map<int, int> tree;
map<int, int> d_level;

void input()
{
    cin >> n >> k;
    
    if (n == 0 && k == 0)
        exit(0);

    for (int i = 1; i <= n; i++)
        cin >> arr[i];
}

void _clear()
{
    memset(arr, 0, sizeof(arr));
    
    for (int i = 0; i < MAX; i++)
        depth[i].clear();

    tree.clear();
    d_level.clear();
}

void make_tree()
{
    int root = arr[1];

    depth[0].push_back(root);
    tree[root] = root;

    // 트리 구성
    int level = 1;
    int depth_pointer = 0;
    int parent = root;
    for (int i = 2; i <= n; i++)
    {
        if (!(arr[i] - arr[i - 1] == 1) && i != 2)
        {
            depth_pointer++;

            if (depth[level - 1].size() < depth_pointer + 1)    // depth_pointer "+ 1" => 갯수 계산 용이하기 위함
            {
                level++;
                depth_pointer = 0;
            }

            parent = depth[level - 1][depth_pointer];
        }

        tree[arr[i]] = parent;
        depth[level].push_back(arr[i]);
        d_level[arr[i]] = level;
    }
}

void find_cousin()
{
    int cousin = 0;
    int k_level = d_level[k];

    if (k_level >= 2)
    {
        int grand = tree[tree[k]];
        for (int i = 0; i < depth[k_level - 1].size(); i++)
        {
            if (depth[k_level - 1][i] == tree[k])
                continue;

            if (tree[depth[k_level - 1][i]] == grand)
            {
                for (int j = 0; j < depth[k_level].size(); j++)
                {
                    if (tree[depth[k_level][j]] == depth[k_level - 1][i])
                        cousin++;
                }
            }
        }
    }

    cout << cousin << "\n";
}

void solution()
{
    make_tree();
    find_cousin();
    _clear();
}

int main()
{
    FAST
    while (1)
    {
        input();
        solution();
    }
    return 0;
}