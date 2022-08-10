import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

// 연속된 구간
class Straight {
    int st;			// 시작 수
    int end;		// 끝 수
    int length;		// 길이

    Straight(int st, int end, int length) {
        this.st = st;
        this.end = end;
        this.length = length;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setLength(int length) {
        this.length = length;
    }

}

public class Main {
    static final int MAX = 1000002;			// 수 범위
    static int n, joker, max;		
    static boolean[] card;
    static ArrayList<Straight> list;
    
    public static void main(String[] args) {
    	input();
    	setList();
    	findMaxStraight();
    }
    
    private static void input() {
    	Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        card = new boolean[MAX];

        // 입력받은 수 체크
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0)
                joker++;
            else 
                card[num] = true;
        }
        
        sc.close();
    }
    
    // 연속된 구간을 담을 List 세팅
    private static void setList() {
    	list = new ArrayList<>();

        boolean check = false;
        int cnt = 0;
        int st = 0;
        // 구간 내에 수가 있으면 st에 기록하고 cnt, 수가 없다면 이전 cnt 길이만큼 list에 추가
        for (int i = 0; i < MAX; i++) {
            if (card[i]) {
                if (!check) {
                    check = true;
                    st = i;
                }
                cnt++;

            } else {
                if (cnt != 0)
                    list.add(new Straight(st, i - 1, cnt));
                check = false;
                cnt = 0;
            }
        }
    }
    
    private static void findMaxStraight() {
    	// 연속된 구간들의 길이 중 최대 길이 + joker
        for (int i = 0; i < list.size(); i++)
            max = Math.max(max, list.get(i).length + joker);

        // 연속된 구간이 없다면 모두 조커이므로 최대길이는 조커의 수
        if (list.size() == 0)
            max = joker;

        // 리스트 별 합쳐질 수 있는 구간이 있는지 체크
        for (int i = 0; i < list.size() - 1; i++) {
            int length = 0;
            int joker_copy = joker;
            
            // 조커를 사용해서 구간이 합쳐지면 i번째 리스트에 구간 조정
            for (int j = i + 1; j < list.size(); j++) {
                int useJoker = list.get(j).st - list.get(i).end - 1;
                if (useJoker <= joker_copy) {
                    length = list.get(j).length + list.get(i).length + useJoker;
                    joker_copy -= useJoker;
                    list.get(i).setEnd(list.get(j).end);
                    list.get(i).setLength(list.get(i).end - list.get(i).st + 1);
                }
            }
            
            // 모두 합친 후에 조커가 남았다면 길이에 + joker
            if (joker_copy > 0)
                length += joker_copy;

            max = Math.max(max, length);
        }
        
        System.out.println(max);
    }
}
