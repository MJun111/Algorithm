#include <iostream>
#include <queue>
#include <string>
using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 27

int n;
char LeftChild[MAX];
char RightChild[MAX];
string ans[3];

void input()
{
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        char a, b, c;
        cin >> a >> b >> c;
        LeftChild[a - 'A'] = b;
        RightChild[a - 'A'] = c;
    }
}

void preorder(char x)
{
    if (x == '.')
        return;

    ans[0] += x;
    preorder(LeftChild[x - 'A']);
    preorder(RightChild[x - 'A']);
}

void inorder(char x)
{
    if (x == '.')
        return;

    inorder(LeftChild[x - 'A']);
    ans[1] += x;
    inorder(RightChild[x - 'A']);
}

void postorder(char x)
{
    if (x == '.')
        return;

    postorder(LeftChild[x - 'A']);
    postorder(RightChild[x - 'A']);
    ans[2] += x;
}

void solution()
{
    char root = 'A';

    preorder(root);
    inorder(root);
    postorder(root);

    for (int i = 0; i < 3; i++)
        cout << ans[i] << "\n";
}

int main()
{
    FAST
    input();
    solution();

    return 0;
}