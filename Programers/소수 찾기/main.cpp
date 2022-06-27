#include <string>
#include <vector>
#include <cmath>
#include <algorithm>
#include <iostream>
using namespace std;

int n = 10000000;           // 10^7
vector<bool> num(n + 1);    // 소수
string nums;                // numbers
vector<char> res;           // 백트래킹으로 만든 순열
int m;                      // m가지 숫자 선택
int ans;                    // 소수 count
bool visited[7];            // 자릿수 판별

// 에라토스테네스의 체
void getPrime()
{
    num[0] = true;
    num[1] = true;
    for (int i = 2; i <= sqrt(n); i++) {
        if (num[i]) continue;
        for (int j = i + i; j <= n; j += i)
            num[j] = true;
    }
}

// 백트래킹
void DFS()
{
    if (res.size() == m)
    {
        string tmp;
        for (char c : res)
            tmp += c;
        if (!num[stoi(tmp)])
        {
            num[stoi(tmp)] = true;
            ans++;
        }
        return;
    }

    for (int i = 0; i < nums.size(); i++)
    {
        if (!visited[i])
        {
            visited[i] = true;
            res.push_back(nums[i]);
            DFS();
            res.pop_back();
            visited[i] = false;
        }
    }
}

int solution(string numbers) {
    int answer = 0;
    nums = numbers;

    getPrime();

    for (int i = 1; i <= nums.size(); i++)
    {
        m = i;
        DFS();
    }
    answer = ans;

    return answer;
}

int main()
{
    string numbers = "111";
    cout << "answer is " << solution(numbers);

    return 0;
}