import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 스위치 개수 만큼 배열 생성
        int n = Integer.parseInt(br.readLine());
        int[] _switch = new int[n];

        // 스위치 배열에 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            _switch[i] = Integer.parseInt(st.nextToken());

        // 학생 수 만큼 조작 실행
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 남학생일 경우 받은 수의 배수만큼 스위치 반전
            if (a == 1) {
                for (int j = b - 1; j < n; j += b)
                    _switch[j] = (_switch[j] + 1) % 2;
            }
            // 여학생일 경우 받은 수의 좌우 대칭을 기준으로 한 칸씩 늘려가며 동일한 상태인지 검사
            else {
                int idx = b - 1;
                int cnt = 1;
                while(true) {
                    // 배열 범위 밖으로 나가면 break
                    if (idx - cnt < 0 || idx + cnt >= n)
                        break;
                    // 스위치의 상태가 같다면 다음 스위치를 조사하기 위해 cnt++
                    if (_switch[idx - cnt] == _switch[idx + cnt])
                        cnt++;
                    else
                        break;
                }
                // 반복문을 빠져나왔다면 이 전 cnt까지 조건을 만족했으므로 cnt - 1
                cnt--;

                // 조건을 만족한 범위만큼 스위치 반전
                for (int j = idx - cnt; j <= idx + cnt; j++)
                    _switch[j] = (_switch[j] + 1) % 2;

            }
        }
        // 문제 형식에 맞게 20개씩 스위치 출력
        for (int i = 0; i < n; i++) {
            if (i != 0 && i % 20 == 0)
                System.out.println();
            System.out.print(_switch[i] + " ");
        }
    }
}
