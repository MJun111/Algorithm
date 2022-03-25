#include <iostream>
#include <string>
#include <vector>
using namespace std;

int answer = 51;
bool visited[51];

void DFS(string begin, string target, vector<string>& words, int count)
{
    if (begin == target)
    {
        if (answer > count)
            answer = count;
    }

    for (int i = 0; i < words.size(); i++)
    {
        if (visited[i])
            continue;

        int digit = 0;

        for (int j = 0; j < words[i].size(); j++)
        {
            if (begin[j] != words[i][j])
                digit++;
        }

        if (digit == 1)
        {
            visited[i] = true;
            DFS(words[i], target, words, count + 1);
            visited[i] = false;
        }
    }
}

int solution(string begin, string target, vector<string> words) {

    DFS(begin, target, words, 0);

    return answer == 51 ? 0 : answer;
}

int main()
{
    string begin = "hit";
    string target = "cog";
    vector<string> words = { "hot", "dot", "dog", "lot", "log", "cog" };

    cout << solution(begin, target, words);

    return 0;
}