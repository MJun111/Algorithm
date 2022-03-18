#include<iostream>
#include<algorithm>
#include<cstring>
#include<queue>
using namespace std;

int map[50][50], visit[50][50];
int N, M;
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};
queue<robot> q;

struct robot{
    int x;
    int y;
    int dir;
};


int main(){
    memset(visit, 0 ,sizeof(visit));
    cin >> N >> M;
    int r, c, d;
    cin >> r >> c >> d;
    
    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            cin >> map[i][j];
        }
    }

    int res = 0;
    q.push({r, c, d});
    
    while(!q.empty()){ 
        robot cur = q.front(); q.pop();
        if(!visit[cur.x][cur.y]) res++; 
        visit[cur.x][cur.y] = 1; 		
        
        bool flag = false;
        
        for(int i=0; i<4; i++){
            int ndir = cur.dir == 0 ? 3 : cur.dir-1; 
            int nx = cur.x + dx[ndir];
            int ny = cur.y + dy[ndir];
            if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1) 
            	continue; 
            if(!visit[nx][ny] && !map[nx][ny]) { 
                q.push({nx, ny, ndir});
                flag = true;
                break;
            }
            
            cur.dir = ndir;
        }
        
        if(flag) 
        	continue;
            
        int nx = cur.x - dx[cur.dir];
        int ny = cur.y - dy[cur.dir];
        
        if(map[nx][ny]) 
        	break; 
            
        q.push({nx, ny, cur.dir}); 
    }
    
    cout << res;
}
