#include <string>
#include <vector>
#include <algorithm>
#include <map>
#include <iostream>
using namespace std;

struct web
{
    int idx;
    int basicPoint;
    vector<string> outLinks;
    double linkPoint;
    double matchPoint;
};

vector<web> Web;
map<string, int> page_num;

string findURL(string str)
{
    string t = "<meta property=\"og:url\" content=\"https://";
    int idx = str.find(t) + t.length();
    string URL = "";

    while (str[idx] != '\"')
        URL += str[idx++];

    return URL;
}

int findWord(string str, string word)
{
    string cur = "";
    int cnt = 0;

    for (int i = 0; i < str.length(); i++)
    {
        if (isalpha(str[i]) == 0)
        {
            if (cur == word)
                cnt++;
            cur = "";
        }
        else
            cur += str[i];
    }
    return cnt;
}

vector<string> findOutLinks(string str)
{
    vector<string> res;
    string t = "<a href=\"https://";
    int idx = str.find(t);

    while (idx != str.npos)
    {
        idx += t.length();
        string cur = "";
        
        while (str[idx] != '\"')
            cur += str[idx++];

        res.push_back(cur);
        str = str.substr(idx);
        idx = str.find(t);
    }
    return res;
}

string ToLower(string str)
{
    transform(str.begin(), str.end(), str.begin(), ::tolower);
    return str;
}

bool _compare(web a, web b)
{
    if (a.matchPoint > b.matchPoint)
        return true;
    if (a.matchPoint == b.matchPoint)
    {
        if (a.idx < b.idx)
            return true;

        return false;
    }
    return false;
}

void calcPoint()
{
    for (int i = 0; i < Web.size(); i++)
    {
        vector<string> Links = Web[i].outLinks;

        for (int j = 0; j < Links.size(); j++)
        {
            string Link = Links[j];
            if (page_num[Link] == 0)
                continue;
            
            int idx = page_num[Link] - 1;
            Web[idx].linkPoint += ((double)Web[i].basicPoint / (double)Links.size());
        }
    }
    for (int i = 0; i < Web.size(); i++)
        Web[i].matchPoint = Web[i].basicPoint + Web[i].linkPoint;
    sort(Web.begin(), Web.end(), _compare);
}

int solution(string word, vector<string> pages) {
    int answer = 0;

    word = ToLower(word);

    for (int i = 0; i < pages.size(); i++)
    {
        string str = ToLower(pages[i]);
        string URL = findURL(str);
        page_num[URL] = i + 1;
        int basicPoint = findWord(str, word);
        vector<string> outLinks = findOutLinks(str);

        Web.push_back({ i, basicPoint, outLinks, 0.0, 0.0 });
    }
    calcPoint();
    answer = Web[0].idx;
    return answer;
}

int main()
{
    string word = "blind";
    vector<string> pages = { "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>" };

    cout << solution(word, pages);

    return 0;
}
