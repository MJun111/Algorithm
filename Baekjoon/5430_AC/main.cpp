#include <iostream>
#include <string>
#include <deque>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int t, n;
string order, s_arr;		// order : 명령, s_arr : ex) [1, 2, 3, 4]

void solution()
{
	cin >> t;
	while (t-- > 0)
	{
		deque<int> arr;		// 정수만 파싱해서 담을 deque
		
		cin >> order;
		cin >> n;
		cin >> s_arr;
		
		string tmp = "";
		for (int i = 1; i < s_arr.size(); i++)
		{
			if (s_arr[i] == ',' || s_arr[i] == ']')
			{
				if (tmp != "")
					arr.push_back(stoi(tmp));
				tmp = "";
				continue;
			}
			tmp += s_arr[i];
		}

		bool check = false;
		int r = 0;
		for (int i = 0; i < order.size(); i++)
		{
			if (order[i] == 'R')
				r++;
			else if (order[i] == 'D' && !arr.empty())
			{
				if (r % 2 == 0)                // 정방향
					arr.pop_front();
				else                           // 역방향
					arr.pop_back();
			}
			else
			{
				cout << "error\n";
				check = true;
				break;
			}
		}

		if (check)			// error 처리 완료
			continue;

		if (arr.empty())	// 남은 원소 X
		{
			cout << "[]\n";
			continue;
		}

		if (r % 2 == 0)		// 정방향 출력
		{
			cout << "[";
			for (int i = 0; i < arr.size() - 1; i++)
				cout << arr[i] << ",";
			cout << arr[arr.size() - 1] << "]";
		}
		else				// 역방향 출력
		{
			cout << "[";
			for (int i = arr.size() - 1; i > 0; i--)
				cout << arr[i] << ",";
			cout << arr[0] << "]";
		}
		cout << "\n";
	}
}

int main()
{
	FAST
		solution();

	return 0;
}