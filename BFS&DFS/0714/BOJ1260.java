import java.io.*;
import java.util.*;

public class BOJ1260 {
	public static StringBuilder sb;
	public static boolean[] visited;
	public static LinkedList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		graph = new LinkedList[n+1];
		visited = new boolean[n+1];
		
		for(int i=1; i<=n; i++) graph[i] = new LinkedList<Integer>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for(int i=1; i<=n; i++)
			if(!graph[i].isEmpty()) Collections.sort(graph[i]);
		
		dfs(v);
		visited = new boolean[n+1];
		bfs(v);
		
		bw.write(sb.toString());
		br.close();
		
		bw.flush();
		bw.close();
	}
	static void dfs(int v) {
		visited[v] = true;
		sb.append(v).append(' ');
		
		for(int i: graph[v]) 
			if(!visited[i]) dfs(i);
	}
	static void bfs(int v) {
		sb.append('\n');
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			v = queue.poll();
			sb.append(v).append(' ');
			
			for(int i: graph[v])
				if(!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
		}
	}
}
