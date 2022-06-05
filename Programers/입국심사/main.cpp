#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

long long solution(int n, vector<int> times) {
    long long left = 0, right = 1000000000000000000;
    while (left < right)
    {
        long long mid = (left + right) / 2;
        long long cnt = 0;
        for (auto t : times)
            cnt += mid / t;

        if (cnt >= n)
            right = mid;
        else
            left = mid + 1;
    }
    return left;
}

int main()
{
    FAST
    int n = 3;
    vector<int> times = { 1, 1, 1 };
    cout << solution(n, times);

    return 0;
}