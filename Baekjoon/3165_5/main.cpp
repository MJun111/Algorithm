#include <iostream>
#include <string>
#include <cmath>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

long long n;
int k, digit;
int num[16];
string str;

void input()
{
    cin >> n >> k;
}

void print()
{
    for (int i = digit; i > 0; i--)
        cout << num[i];
    
    cout << "\n";
}

bool check()
{
    int cnt = 0;

    for (int i = 1; i <= digit; i++)
        if (num[i] == 5)
            cnt++;

    if (cnt >= k)
    {
        return true;
    }

    return false;
}

void solution()
{
    n += 1;
    str = to_string(n);
    digit = str.size();
    
    for (int i = digit - 1; i >= 0; i--)
        num[digit - i] = str[i] - '0';

    if (check())
    {
        /*
        long long number = 0;
        for (int i = 1; i <= digit; i++)
            number += (long long)pow(10, i - 1) * num[i];

        cout << number << "\n";
        */
        print();
    }
    else {
        for (int i = 1; i <= digit; i++)
        {
            while (num[i] != 5)
            {
                num[i]++;
                int idx = 0;

                while (num[i + idx] == 10)
                {
                    num[i + idx + 1]++;
                    num[i + idx] = 0;
                    idx++;
                }

                if (check())
                {
                    //print(); // -> ?
                    
                    long long number = 0;
                    for (int i = 1; i <= digit; i++)
                        number += (long long)pow(10, i - 1) * num[i];

                    cout << number << "\n";
                    exit(0);
                }
            }
        }
    }
    for (int i = 1; i <= k; i++)
        cout << "5";
}

int main()
{
    FAST
    input();
    solution();
    return 0;
}