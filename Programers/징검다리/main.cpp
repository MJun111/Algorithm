#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int solution(int distance, vector<int> rocks, int n) {
    int answer = 0;
    sort(rocks.begin(), rocks.end());
    int left = 0, right = distance;

    while (left <= right)
    {
        int mid = (left + right) / 2;
        int prev = 0;
        int cnt = 0;

        for (auto r : rocks)
        {
            if (r - prev < mid)     // 바위 제거
                cnt++;
            else
                prev = r;           // 이전 바위 위치 갱신
        }

        if (distance - prev < mid)  // 마지막 부분 탐색
            cnt++;

        if (cnt <= n)               // 바위 사이 거리값을 mid로 할 수 있는 경우 -> 바위 n개 이하 제거
        {
            answer = max(mid, answer);
            left = mid + 1;
        }
        else
            right = mid - 1;
    }

    return answer;
}

int main()
{
    FAST
    int dis = 25;
    vector<int> rocks = { 2, 14, 11, 21, 17 };
    int n = 2;
    cout << solution(dis, rocks, n);

    return 0;
}