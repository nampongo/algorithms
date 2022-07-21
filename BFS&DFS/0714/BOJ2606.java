import java.util.*;
import java.io.*;

public class BOJ2606 {
	static Queue<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		graph = new LinkedList[n+1];
		for(int i=1; i<=n; i++) graph[i] = new LinkedList<>();
		
		for(int i=0; i<m; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(s.nextToken());
			int b = Integer.parseInt(s.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		bfs(n);
	}
	static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
 		
		queue.add(1);
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int i = queue.poll();
			if(visited[i]) continue;
			
			while(!graph[i].isEmpty()) queue.add(graph[i].poll());
			visited[i] = true;
			cnt++;
		}
		System.out.println(cnt-1);
	}
}
