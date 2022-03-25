#include <iostream>
#include <string>
#include <vector>
using namespace std;

int answer = 0;
bool visited[201];
int N;

void DFS(int num, vector<vector<int>>& com)
{
    visited[num] = true;

    for (int i = 0; i < N; i++)
    {
        if (!visited[i] && com[num][i])
            DFS(i, com);
    }

}

int solution(int n, vector<vector<int>> computers) {
    N = n;

    for (int i = 0; i < n; i++)
        if (!visited[i])
        {
            answer++;
            DFS(i, computers);
        }

    return answer;
}

int main()
{
    int n = 3;
    vector<vector<int>> computers = { {1, 1, 0}, {1, 1, 0}, {0, 0, 1} };

    cout << solution(n, computers);

    return 0;
}