#include <iostream>
#include <string>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

long long n;
int k;
string str;

void input()
{
    cin >> n >> k;
}

void solution()
{
    int origin_k = k;
    if (k == 15)
    {
        cout << "555555555555555\n";
        exit(0);
    }

    str = to_string(n);
    int size = str.size();
    int i = size - 1;
    int point = i - k;

    if (point >= 1)
		for (int i = point - 1; i >= 0; i--)
			if (str[i] == '5')
				k--;

    point = i - k;
    int cnt = k;
    while (1)
    {
        if (cnt == 0)
        {
            if (n < stoll(str))
            {
                cout << str << "\n";
                break;
            }

            if (str[point] == '9')
            {
				str = "1";
				for (int x = 0; x < size; x++)
					str += '0';
				size++;
                k = origin_k;
            }
            else
            {
                int num = str[point] - '0';
                num++;
                str[point] = (char)(num + '0');
            }
            
            i = size - 1;
            point = i - k;
            cnt = k;
        }

        str[i] = '5';
        cnt--;
        i--;
    }
}

int main()
{
    FAST
    input();
    solution();
    return 0;
}