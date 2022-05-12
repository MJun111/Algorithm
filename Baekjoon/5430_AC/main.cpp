#include <iostream>
#include <string>
#include <deque>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100000 + 1

int t, n;
string order, s_arr;		// order : ���, s_arr : ex) [1, 2, 3, 4]

void solution()
{
	cin >> t;
	while (t-- > 0)
	{
		deque<int> arr;		// ������ �Ľ��ؼ� ���� deque
		
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
				if (r % 2 == 0)                // ������
					arr.pop_front();
				else                           // ������
					arr.pop_back();
			}
			else
			{
				cout << "error\n";
				check = true;
				break;
			}
		}

		if (check)			// error ó�� �Ϸ�
			continue;

		if (arr.empty())	// ���� ���� X
		{
			cout << "[]\n";
			continue;
		}

		if (r % 2 == 0)		// ������ ���
		{
			cout << "[";
			for (int i = 0; i < arr.size() - 1; i++)
				cout << arr[i] << ",";
			cout << arr[arr.size() - 1] << "]";
		}
		else				// ������ ���
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