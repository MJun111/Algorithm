#include <iostream>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int solution(vector<int> nums)
{
    set<int> s;
    for (int n : nums)
        s.insert(n);

    return min(nums.size() / 2, s.size());
}

int main()
{
    FAST
    vector<int> nums = {3, 3, 3, 2, 2, 4};
    cout << solution(nums);

    return 0;
}