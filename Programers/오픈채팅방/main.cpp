#include <vector>
#include <string>
#include <map>
#include <iostream>
using namespace std;

vector<string> split(string& str, char c)
{
    vector<string> vs;
    string tmp;

    for (int i = 0; i < str.size(); i++)
    {
        if (str[i] == c)
        {
            vs.push_back(tmp);
            tmp.clear();
        }
        else
            tmp += str[i];
    }
    vs.push_back(tmp);

    return vs;
}

vector<string> solution(vector<string> record) {
    vector<string> answer;
    map<string, string> user;
    vector<pair<string, string>> inout;

    for (int i = 0; i < record.size(); i++)
    {
        vector<string> sp_record = split(record[i], ' ');

        if (sp_record[0] != "Leave")            // Leave 제외 닉네임 저장
            user[sp_record[1]] = sp_record[2];

        if (sp_record[0] == "Enter")            // Enter 일 경우 user ID 와 "in"
            inout.push_back({ sp_record[1], "in" });

        if (sp_record[0] == "Leave")            // Leave 일 경우 user ID 와 "out"
            inout.push_back({ sp_record[1], "out" });

    }

    for (int i = 0; i < inout.size(); i++)
    {
        string ans;
        if (inout[i].second == "in")
            ans = user[inout[i].first] + "님이 들어왔습니다.";
        else
            ans = user[inout[i].first] + "님이 나갔습니다.";

        answer.push_back(ans);
    }

    return answer;
}

int main()
{
    vector<string> record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan" };
    vector<string> ans = solution(record);

    for (auto a : ans)
        cout << a << "\n";

    return 0;
}