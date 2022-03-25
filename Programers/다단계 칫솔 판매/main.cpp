#include <iostream>
#include <vector>
#include <string>
#include <map>
using namespace std;
#define MAX 10001

map<string, int> member;
int parent[MAX];
int profits[MAX];

void distribute(int n, int profit)
{
    // �ֻ��� �θ��� ��� ����
    if (n == -1)
        return;

    int give = profit / 10;
    profits[n] += profit - give;

    // �� ���� ���� ��� ���� (1�� �̸�)
    if (!give)
        return;

    distribute(parent[n], give);
}

vector<int> solution(vector<string> enroll, vector<string> referral, vector<string> seller, vector<int> amount) {
    vector<int> answer;

    // ȸ�� ����
    for (int i = 0; i < enroll.size(); i++)
        member[enroll[i]] = i;

    // �θ� ����
    for (int i = 0; i < referral.size(); i++)
    {
        if (referral[i] == "-")
            parent[i] = -1;
        else
            parent[i] = member[referral[i]];
    }

    for (int i = 0; i < seller.size(); i++)
        distribute(member[seller[i]], amount[i] * 100);

    for (int i = 0; i < enroll.size(); i++)
        answer.push_back(profits[i]);

    return answer;
}

int main()
{
    vector<string> enroll = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
    vector<string> referral = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" }; 
    vector<string> seller = { "young", "john", "tod", "emily", "mary" };
    vector<int> amount = { 12, 4, 2, 5, 10 };

    vector<int> ans = solution(enroll, referral, seller, amount);

    for (auto a : ans)
        cout << a << ", ";
    

    return 0;
}