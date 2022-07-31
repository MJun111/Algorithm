#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 101

int n, k;                   // n : ��ǻ�� ��, k : ����� ��ǻ���� ��
int cnt = 0;                // 1�� ��ǻ�ͷ� ���� ������ ��ǻ�� ��
bool visited[MAX];          
vector<int> network[MAX];   // ����

void input()
{
    cin >> n >> k;
    
    for (int i = 0; i < k; i++)
    {
        int a, b;
        cin >> a >> b;
        network[a].push_back(b);        // ���� ����� �߰�
        network[b].push_back(a);
    }
}

void DFS(int n)
{
    visited[n] = true;
  
    for (int i = 0; i < network[n].size(); i++)
    {
        int connect = network[n][i];
        if (!visited[connect])      // �湮 Ȯ��
        {
            DFS(connect);
            cnt++;
        }
    }
}

void solution()
{
    DFS(1);
    cout << cnt;
}

int main(void)
{
    input();
    solution();

    return 0;
}
