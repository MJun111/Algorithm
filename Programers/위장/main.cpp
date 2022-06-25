#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    unordered_map<string, int> m;

    for (int i = 0; i < clothes.size(); i++)
        m[clothes[i][1]]++;
    
    for (auto iter = m.begin(); iter != m.end(); iter++)
        answer *= (iter->second + 1);

    return answer - 1;
}

int main()
{
    FAST
    vector<vector<string>> clothes = { {"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"} };
    cout << solution(clothes);

    return 0;
}