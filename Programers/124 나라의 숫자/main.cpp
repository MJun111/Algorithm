#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

string solution(int n) {
    string answer = "";
    string str[] = { "4", "1", "2" };

    while (n > 0)
    {
        answer += str[n % 3];
        if (n % 3 == 0)
            n = (n / 3) - 1;
        else
            n = n / 3;
    }
    reverse(answer.begin(), answer.end());
    return answer;
}

int main()
{
    int n = 4;

    cout << solution(n);

    return 0;
}