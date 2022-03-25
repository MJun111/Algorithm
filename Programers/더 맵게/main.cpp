#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <iostream>
using namespace std;

int mix(int a, int b)
{
    return a + 2 * b;
}

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, vector<int>, greater<int>> pq;

    for (int i = 0; i < scoville.size(); i++)
        pq.push(scoville[i]);

    while (pq.top() < K)
    {
        if (pq.size() < 2)
        {
            answer = -1;
            break;
        }

        int a, b;
        a = pq.top();
        pq.pop();
        b = pq.top();
        pq.pop();
        pq.push(mix(a, b));
        answer++;
    }

    return answer;
}

int main()
{
    vector<int> scoville = { 1, 2, 3, 9, 10, 12 };
    int K = 7;

    cout << solution(scoville, K);

    return 0;
}