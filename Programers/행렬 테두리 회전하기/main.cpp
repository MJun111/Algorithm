#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

vector<int> solution(int rows, int columns, vector<vector<int>> queries) {
    vector<int> answer;
    vector<vector<int>> table(rows);

    int n = 1;
    for (int i = 0; i < rows; i++)
        for (int j = 0; j < columns; j++)
            table[i].push_back(n++);

    for (int i = 0; i < queries.size(); i++)
    {
        int y = queries[i][0] - 1;
        int x = queries[i][1] - 1;
        int width = queries[i][3] - queries[i][1];
        int height = queries[i][2] - queries[i][0];

        vector<int> tmp;
        int minNum = rows * columns;

        // ->
        tmp.push_back(table[y][x]);

        for (int j = 0; j < width; j++, x++)
        {
            tmp.push_back(table[y][x + 1]);

            table[y][x + 1] = tmp.front();
            minNum = min(tmp.front(), minNum);
            tmp.erase(tmp.begin());
        }

        // down
        for (int j = 0; j < height; j++, y++)
        {
            tmp.push_back(table[y + 1][x]);

            table[y + 1][x] = tmp.front();
            minNum = min(tmp.front(), minNum);
            tmp.erase(tmp.begin());
        }

        // <-
        for (int j = 0; j < width; j++, x--)
        {
            tmp.push_back(table[y][x - 1]);

            table[y][x - 1] = tmp.front();
            minNum = min(tmp.front(), minNum);
            tmp.erase(tmp.begin());
        }

        // up
        for (int j = 0; j < height; j++, y--)
        {
            tmp.push_back(table[y - 1][x]);

            table[y - 1][x] = tmp.front();
            minNum = min(tmp.front(), minNum);
            tmp.erase(tmp.begin());
        }
        answer.push_back(minNum);
    }
    return answer;
}

int main()
{
    int rows = 6; 
    int columns = 6;
    vector<vector<int>> queries = { {2,2,5,4}, {3,3,6,6}, {5,1,6,3} };

    vector<int> ans = solution(rows, columns, queries);

    for (auto a : ans)
        cout << a << ", ";

    return 0;
}