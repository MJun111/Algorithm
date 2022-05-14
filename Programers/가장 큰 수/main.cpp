#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

bool comp(string a, string b)
{
    return a + b > b + a;
}

string solution(vector<int> numbers) {
    string answer = "";
    
    vector<string> s;
    for (auto x : numbers)
        s.push_back(to_string(x));

    sort(s.begin(), s.end(), comp);
    
    if (s.at(0) == "0")
        return "0";
    
    for (auto n : s)
        answer += n;

    return answer;
}

int main()
{
    FAST
    vector<int> numbers = { 3, 30, 34, 5, 9 };
    solution(numbers);

    return 0;
}