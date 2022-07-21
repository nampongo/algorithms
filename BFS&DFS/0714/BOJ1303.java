import java.io.*;
import java.util.*;

public class BOJ1303 {
	public static boolean[][] war, visited;
	public static int n, m, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		war = new boolean[m][n]; // B=true, W=false
		visited = new boolean[m][n];
		
		for(int i=0; i<m; i++) {
			char[] row = (br.readLine()).toCharArray();
			for(int j=0; j<n; j++)
				if(row[j]=='B') war[i][j] = true;
		}
		
		int blue=0, white=0;
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					cnt = 0;
					dfs(i, j, war[i][j]);
					
					if(war[i][j]) blue += cnt*cnt;
					else white += cnt*cnt;
				}
			}
		
		sb.append(white).append(' ').append(blue);
		bw.write(sb.toString());
		br.close();
		
		bw.flush();
		bw.close();
	}
	static void dfs(int i, int j, boolean t) {
		visited[i][j] = true;
		cnt++;
		
		int[][] search = {{i-1, j}, {i+1, j}, {i, j-1}, {i, j+1}};
		
		for(int k=0; k<4; k++) {
			int a = search[k][0], b = search[k][1];
			if(a<0 || a>=m || b<0 || b>=n) continue;
			if(!visited[a][b] && war[a][b]==t) dfs(a, b, t);
		}
	}
}
