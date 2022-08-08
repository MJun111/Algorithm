import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


    }
    
    static void permu(int[] in, int[] out, boolean[] visited, int depth) {
      if (depth == m) {
        for (int i = 0; i < m; i++) {
          System.out.print(out[i] + " ");
        }
        System.out.println();
        return;
      }
      
      for (int i = 0; i < n; i++) {
        if (!visited[i]) {
          visited[i] = true;
          out[depth] = in[i];
          permu(in, out, visited, depth + 1);
          visited[i] = false;
        }
    }
    
    static void combi(int[] in, int[] out, int start, int depth) {
      if (depth == m) {
        for (int i = 0; i < m; i++) {
          System.out.print(out[i] + " ");
        }
        System.out.println();
        return;
      }
      
      for (int i = start; i < n; i++) {
        out[depth] = in[i];
        combi(in, out, i + 1, depth + 1);
      }
    }
      
    static void re_permu(int[] in, int[] out, int depth) {
      if (depth == m) {
        for (int i = 0; i < m; i++) {
          System.out.print(out[i] + " ");
        }
        System.out.println();
        return;
      }
      
      for (int i = 0; i < n; i++) {
        out[depth] = in[i];
        re_permu(in, out, depth + 1);
      }
    }
    
    static void re_combi(int[] in, int[] out, int start, int depth) {
      if (depth == m) {
        for (int i = 0; i < m; i++) {
          System.out.print(out[i] + " ");
        }
        System.out.println();
        return;
      }
      
      for (int i = start; i < n; i++) {
        out[depth] = in[i];
        re_combi(in, out, i, depth + 1);
      }
    }
    
    static void subset(int[] in, int[] out, boolean[] visited, int depth) {
      if (depth == n) {
        for (int i = 0; i < m; i++) {
          if (visited[i])
            out[i] = in[i];
          else
            out[i] = -1;
        }
        System.out.println(Arrays.toString(out));
        return;
      }
      
      visited[depth] = true;
      subset(in, out, visited, depth + 1);
      visited[depth] = false;
      subset(in, out, visited, depth + 1);
    }
}
