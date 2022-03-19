#include <iostream>
#include <string>
#include <stack>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

int main() {
	FAST
	string str;
	stack<char> st;
	int tmp = 1, ans = 0;	// tmp : 중간계산 값
	bool err = false;		// err : 오류판별 변수

	getline(cin, str);

	for (int i = 0; i < str.length(); i++)
	{
		// #1 
		if (str[i] == '(')
		{
			st.push(str[i]);
			tmp *= 2;
		}
		else if (str[i] == '[')
		{
			st.push(str[i]);
			tmp *= 3;
		}

		// #2 
		else if (str[i] == ')')
		{
			// #2-1
			if (st.empty() || st.top() != '(') 
			{
				err = true;
				break;
			}
			// #2-2 
			else if (str[i - 1] == '(')
			{
				ans += tmp;
				tmp /= 2;
				st.pop();
			}
			// #2-3
			else
			{
				tmp /= 2;
				st.pop();
			}
		}

		else if (str[i] == ']')
		{
			if (st.empty() || st.top() != '[')
			{
				err = true;
				break;
			}
			else if (str[i - 1] == '[')
			{
				ans += tmp;
				tmp /= 3;
				st.pop();
			}
			else
			{
				tmp /= 3;
				st.pop();
			}
		}
	}

	if (!st.empty())
		err = true;
	
	if (err)
		ans = 0;

	cout << ans << "\n";

	return 0;
}
