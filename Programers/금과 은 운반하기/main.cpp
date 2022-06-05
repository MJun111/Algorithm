#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

bool Search(int a, int b, vector<int> g, vector<int> s, vector<int> w, vector<int> t, long long Mid)
{
    long long Total_Gold = 0;
    long long Total_Silver = 0;
    long long Total_Mineral = 0;

    for (int i = 0; i < g.size(); i++)
    {
        long long Time = t[i];

        long long Round_Time = Time * 2;            // �պ� �ð�
        long long Move_Cnt = Mid / Round_Time;      // �̵� Ƚ��
        if (Mid % Round_Time >= Time) Move_Cnt++;   // �� 1ȸ ���� ����
        long long Max_Take = w[i] * Move_Cnt;       // �ð� ���� �ű� �� �ִ� �ִ� ��

        Total_Gold += min((long long)g[i], Max_Take);   
        Total_Silver += min((long long)s[i], Max_Take);
        Total_Mineral += min((long long)g[i] + s[i], Max_Take); 
    }

    if (Total_Gold >= a && Total_Silver >= b && Total_Mineral >= (long long)a + b) return true;
    return false;
}

long long solution(int a, int b, vector<int> g, vector<int> s, vector<int> w, vector<int> t)
{
    long long answer = -1;
    long long Start = 0;
    long long End = 10e14 * 3;
    answer = End;
    while (Start <= End)
    {
        long long Mid = (Start + End) / 2;
        if (Search(a, b, g, s, w, t, Mid) == true)
        {
            answer = min(answer, Mid);
            End = Mid - 1;
        }
        else Start = Mid + 1;
    }

    return answer;
}

int main()
{
    FAST
    int a = 90;
    int b = 500;
    vector<int> g, s, w, t;
    g.push_back(70);
    g.push_back(70);
    g.push_back(0);
    s.push_back(0);
    s.push_back(0);
    s.push_back(500);
    w.push_back(100);
    w.push_back(100);
    w.push_back(2);
    t.push_back(4);
    t.push_back(8);
    t.push_back(1);
    cout << solution(a, b, g, s, w, t);

    return 0;
}