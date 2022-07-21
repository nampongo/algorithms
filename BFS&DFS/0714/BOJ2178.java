import java.io.*;
import java.util.*;

public class BOJ2178 {
	public static int[][] maze;
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		maze = new int[n][m];
		 
		for(int i=0; i<n; i++) {
			String row = br.readLine();
			for(int j=0; j<m; j++) maze[i][j] = row.charAt(j)-'0';
		}
		
		bfs(n, m);
		
		bw.write((maze[n-1][m-1]+" ").toString());
		br.close();
		
		bw.flush();
		bw.close();
	}
	
	static void bfs(int n, int m) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0});
		
		while(!queue.isEmpty()) {
			int[] v = queue.poll();
			int a = v[0], b= v[1];
			
			int[][] search = {{a-1, b}, {a+1, b}, {a, b-1}, {a, b+1}};
			
			for(int k=0; k<4; k++) {
				int x = search[k][0], y = search[k][1];
				if(x<0 || x>=n || y<0 || y>=m) continue;
				
				if(maze[x][y] == 1 && (x+y)!=0) {
					maze[x][y] = maze[a][b]+1;
					queue.add(new int[] {x, y});
				}
			}
		}
	}
}