#include <string>
#include <vector>
#include <map>
#include <set>

using namespace std;

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer;
    map<string, int> report_cnt;
    map<string, set<string>> report_user;
    
    for (string s : report)
    {
        int blank = s.find(' ');
        string from = s.substr(0, blank);
        string to = s.substr(blank);
        
        if (report_user[from].find(to) == report_user[from].end())
        {
            report_cnt[to]++;
            report_user[from].insert(to);
        }
    }
    
    for (string s : id_list)
    {
        int res = 0;
        
        for (string s2 : report_user[s])
        {
            if (report_cnt[s2] >= k)
                res++;
        }
        
        answer.push_back(res);
    }
    
    
    return answer;
}
