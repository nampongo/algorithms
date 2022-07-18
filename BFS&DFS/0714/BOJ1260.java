import java.io.*;
import java.util.*;

public class BOJ1260 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer>[] graph = new LinkedList[n+1];
		boolean[] visited = new boolean[n+1];
		
		for(int i=1; i<=n; i++) graph[i] = new LinkedList<Integer>();
	}
}