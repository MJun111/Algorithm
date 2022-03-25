#include <vector>
#include <iostream>
using namespace std;

int answer = 0;
int t;
vector<int> num;

void DFS(int sum, int cnt)
{
    if (cnt == num.size())
    {
        if (sum == t)
            answer++;
    }
    else
    {
        DFS(sum + num[cnt], cnt + 1);
        DFS(sum - num[cnt], cnt + 1);
    }
}

int solution(vector<int> numbers, int target) {

    t = target;

    for (auto n : numbers)
        num.push_back(n);

    DFS(num[0], 1);
    DFS(-num[0], 1);

    return answer;
}

int main()
{
    vector<int> numbers = {1, 1, 1, 1, 1};
    int target = 3;

    cout << solution(numbers, target);
    return 0;
}