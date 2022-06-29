#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

vector<string> solution(vector<string> orders, vector<int> course) {
    vector<string> answer;

    for (int i = 0; i < orders.size(); i++)
        sort(orders[i].begin(), orders[i].end());

    for (int c = 0; c < course.size(); c++)
    {
        map<string, int> m;
        for (int i = 0; i < orders.size(); i++)
        {
            if (orders[i].size() < course[c]) continue;

            vector<bool> tmp(orders[i].size(), false);
            for (int j = 0; j < course[c]; j++)
                tmp[j] = true;

            do {
                string str;
                for (int j = 0; j < orders[i].size(); j++)
                {
                    if (tmp[j])
                        str += orders[i][j];
                }
                m[str]++;
            } while (prev_permutation(tmp.begin(), tmp.end()));
        }

        int cnt = 2;
        for (auto iter = m.begin(); iter != m.end(); iter++)
            if (cnt < iter->second)
                cnt = iter->second;

        for (auto iter = m.begin(); iter != m.end(); iter++)
            if (iter->second == cnt)
                answer.push_back(iter->first);
    }

    sort(answer.begin(), answer.end());

    return answer;
}

int main()
{
    FAST
    vector<string> orders = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" };
    vector<int> course = {2, 3, 5};
    solution(orders, course);

    return 0;
}