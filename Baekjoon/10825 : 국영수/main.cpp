#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

class Student
{
public:
	string name;
	int kor, eng, math;
};

bool compare(Student a, Student b)
{
	if (a.kor == b.kor)
	{
		if (a.eng == b.eng)
		{
			if (a.math == b.math)
			{
				return a.name < b.name;
			}
			else
				return a.math > b.math;
		}
		else
			return a.eng < b.eng;
	}
	else
		return a.kor > b.kor;

}

int main() {
	FAST
	int n;
	
	cin >> n;
	vector<Student> students(n);
	
	for (int i = 0; i < n; i++)
	{
		cin >> students[i].name >> students[i].kor >> students[i].eng >> students[i].math;
	}

	stable_sort(students.begin(), students.end(), compare);

	for (int i = 0; i < n; i++)
	{
		cout << students[i].name << "\n";
	}

	return 0;
}
