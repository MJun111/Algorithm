#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

// #2-2
bool compare(pair<int, string> a, pair<int, string> b)
{
	return a.first < b.first;
}

int main() {
	FAST
    // #1
	int n, age;
	string name;
	vector<pair<int, string>> vec;

	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> age >> name;
		vec.push_back(pair<int, string>(age, name));
	}
    
    // #2-1
	stable_sort(vec.begin(), vec.end(), compare);

	for (int i = 0; i < n; i++)
	{
		cout << vec[i].first << " " << vec[i].second << "\n";
	}

	return 0;
}
