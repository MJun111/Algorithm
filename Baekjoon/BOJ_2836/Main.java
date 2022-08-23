import java.io.*;
import java.util.*;

class Edge {
	long start, end;
	
	Edge(long start, long end) {
		this.start = start;
		this.end = end;
	}
	
}

public class Main {
	static int n, m;
	static ArrayList<Edge> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			if (a < b) continue;
			list.add(new Edge(a, b));
		}
		
		Collections.sort(list, (o1, o2) -> Long.compare(o1.end, o2.end));
		
		long ans = m;
		long start = list.get(0).start;
		long end = list.get(0).end;
		long length = start - end;
		for (Edge edge : list) {
			if (edge.end <= start) {
				if (edge.start > start) {
					length += edge.start - start;
					start = edge.start;
				}
				if (edge.end < end) {
					length += end - edge.end;
					end = edge.end;
				}
			}
			else {
				ans += 2*length;
				start = edge.start;
				end = edge.end;
				length = start - end;
			}
		}
		
		ans += 2*length;
		
		System.out.println(ans);
    }

}
