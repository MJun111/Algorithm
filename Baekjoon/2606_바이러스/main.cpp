#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 101

int n, k;                   // n : 컴퓨터 수, k : 연결된 컴퓨터의 쌍
int cnt = 0;                // 1번 컴퓨터로 인해 감염된 컴퓨터 수
bool visited[MAX];          
vector<int> network[MAX];   // 에지

void input()
{
    cin >> n >> k;
    
    for (int i = 0; i < k; i++)
    {
        int a, b;
        cin >> a >> b;
        network[a].push_back(b);        // 에지 양방향 추가
        network[b].push_back(a);
    }
}

void DFS(int n)
{
    visited[n] = true;
  
    for (int i = 0; i < network[n].size(); i++)
    {
        int connect = network[n][i];
        if (!visited[connect])      // 방문 확인
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
