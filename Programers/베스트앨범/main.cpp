#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <iostream>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

bool _comp(pair<string, int> a, pair<string, int> b)
{
    return a.second > b.second;
}

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    vector<pair<string, int>> rank;
    unordered_map<string, int> m;

    for (int i = 0; i < genres.size(); i++)
        m[genres[i]] += plays[i];

    for (auto iter = m.begin(); iter != m.end(); iter++)
        rank.push_back({ iter->first, iter->second });

    sort(rank.begin(), rank.end(), _comp);

    for (int i = 0; i < rank.size(); i++)
    {
        int max1 = -1, max2 = -1;
        int num1 = -1, num2 = -1;
        for (int j = 0; j < genres.size(); j++)
        {
            if (genres[j] == rank[i].first)
            {
                if (plays[j] > max1)
                {
                    max2 = max1;
                    max1 = plays[j];
                    num2 = num1;
                    num1 = j;
                }
                else if (plays[j] > max2)
                {
                    max2 = plays[j];
                    num2 = j;
                }
            }
        }
        if (num1 != -1)
            answer.push_back(num1);
        if (num2 != -1)
            answer.push_back(num2);
    }

    return answer;
}

int main()
{
    FAST
    vector<string> genres = { "classic", "pop", "classic", "classic", "pop" };
    vector<int> plays = { 500, 600, 150, 800, 2500 };
    solution(genres, plays);

    return 0;
}