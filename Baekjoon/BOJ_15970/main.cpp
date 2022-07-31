#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int n;
vector<pair<int, int>> d;
vector<vector<int>> vec;
vector<int> tmp;

void input()
{
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        int a, b;
        cin >> a >> b;
        d.push_back({ a, b });      // a : ��ġ, b : ����
    }
}

bool _compare(pair<int, int> a, pair<int, int> b)
{
    return a.second < b.second;
}

// ���� �迭 �л� �� ����
void splitDot()
{
    sort(d.begin(), d.end(), _compare);

    tmp.push_back(d[0].first);
    for (int i = 1; i < n; i++)
    {
        if (d[i - 1].second == d[i].second)
            tmp.push_back(d[i].first);

        else
        {
            vec.push_back(tmp);
            tmp.clear();
            tmp.push_back(d[i].first);
        }
    }

    if (!tmp.empty())
        vec.push_back(tmp);

    for (int i = 0; i < vec.size(); i++)
        sort(vec[i].begin(), vec[i].end());
}

void calcDis()
{
    int ans = 0;

    // ���� ����
    for (int i = 0; i < vec.size(); i++)
    {
        int dis = 0;

        dis += vec[i][1] - vec[i][0];                                   // ù ��
        dis += vec[i][vec[i].size() - 1] - vec[i][vec[i].size() - 2];   // �� ��

        for (int j = 1; j < vec[i].size() - 1; j++)                     // ������ �� �� ����� �Ÿ� +
            dis += (vec[i][j] - vec[i][j - 1]) > (vec[i][j + 1] - vec[i][j]) ? (vec[i][j + 1] - vec[i][j]) : (vec[i][j] - vec[i][j - 1]);

        ans += dis;
    }

    cout << ans;
}

void solution()
{
    splitDot();
    calcDis();
}

int main(void)
{
    FAST
    input();
    solution();

    return 0;
}