#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

vector<string> answer;
bool visited[10001];

bool DFS(string st, vector<vector<string>> tickets, int cnt)
{
    if (cnt == tickets.size())
        return true;

    for (int i = 0; i < tickets.size(); i++)
    {
        if (tickets[i][0] == st && !visited[i])
        {
            visited[i] = true;
            answer.push_back(tickets[i][1]);
            bool next = DFS(tickets[i][1], tickets, cnt + 1);
            
            if (next)
                return true;

            visited[i] = false;
        }
    }
    answer.pop_back();
    return false;
}

vector<string> solution(vector<vector<string>> tickets) {
    
    sort(tickets.begin(), tickets.end());
    answer.push_back("ICN");
    DFS("ICN", tickets, 0);

    return answer;
}

int main()
{
    FAST
    vector<vector<string>> tickets = { {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"} };
    solution(tickets);

    return 0;
}