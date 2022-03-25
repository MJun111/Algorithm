#include <iostream>
using namespace std;

long long getGcd(long long a, long long b)
{
    long long n;

    while (b != 0)
    {
        n = a % b;
        a = b;
        b = n;
    }

    return a;
}

long long solution(int w, int h) {
    long long answer;

    long long W = w;
    long long H = h;

    if (w == h) {
        answer = (W * H) - W;
    }

    else {

        long long gcd = getGcd(W, H);

        answer = (W * H) - (((W / gcd) + (H / gcd) - 1) * gcd);
    }

    return answer;
}

int main()
{
    int w = 8, h = 12;

    cout << solution(w, h);
    return 0;
}