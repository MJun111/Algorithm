#include <iostream>
#include <string>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int t;
string s;

void solution()
{
    cin >> t;
    for (int i = 1; i <= t; i++)
    {
        cin >> s;

        int n = stoi(s);
        int maxNum = n;
        int minNum = n;

        for (int i = 0; i < s.size(); i++)
        {
            for (int j = i + 1; j < s.size(); j++)
            {
                int tmp = n;
                string s1 = to_string(tmp);
                swap(s1[i], s1[j]);
                if (s1[0] == '0')
                    continue;

                tmp = stoi(s1);
                if (maxNum < tmp)
                    maxNum = tmp;
                if (minNum > tmp)
                    minNum = tmp;
            }
        }
        cout << "#" << i << " " << minNum << " " << maxNum << "\n";
    }
}

int main()
{
    FAST
    solution();

    return 0;
}