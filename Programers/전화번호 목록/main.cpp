#include <iostream>
#include <string>
#include <vector>
#include <map>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

bool solution(vector<string> phone_book) {
    map<string, int> m;

    for (int i = 0; i < phone_book.size(); i++)
        m[phone_book[i]] = 1;
    
    for (int i = 0; i < phone_book.size(); i++)
    {
        string phone_num;
        for (int j = 0; j < phone_book[i].size(); j++)
        {
            phone_num += phone_book[i][j];
            if (m[phone_num] && phone_num != phone_book[i])
                return false;
        }
    }
    return true;
}

int main()
{
    FAST
    vector<string> phone_book = { "123","456","789" };
    cout << boolalpha << solution(phone_book);

    return 0;
}