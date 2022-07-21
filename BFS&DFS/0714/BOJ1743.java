import java.io.*;
import java.util.*;

public class BOJ1743 {
	public static boolean[][] map;
	public static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new boolean[n][m];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] = true;
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]) {
					int tmp = bfs(i, j);
					if(tmp > max) max = tmp;
				}
			}
		}
		
		bw.write((max+" ").toString());
		br.close();
		
		bw.flush();
		bw.close();
	}
	static int bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j});
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int[] v = queue.poll();
			int a = v[0], b = v[1];
			
			int[][] search = {{a-1, b}, {a+1, b}, {a, b-1}, {a, b+1}};
			
			for(int k=0; k<4; k++) {
				int x = search[k][0], y = search[k][1];
				if(x<0 || x>=n || y<0 || y>=m) continue;
				
				if(map[x][y]) {
					queue.add(new int[] {x, y});
					map[x][y] = false;
					cnt++;
				}
			}
		}
		return cnt;
	}
}