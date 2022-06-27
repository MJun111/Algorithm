#include <string>
#include <vector>
#include <cmath>
#include <algorithm>
#include <iostream>
using namespace std;

int n = 10000000;           // 10^7
vector<bool> num(n + 1);    // �Ҽ�
string nums;                // numbers
vector<char> res;           // ��Ʈ��ŷ���� ���� ����
int m;                      // m���� ���� ����
int ans;                    // �Ҽ� count
bool visited[7];            // �ڸ��� �Ǻ�

// �����佺�׳׽��� ü
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

// ��Ʈ��ŷ
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