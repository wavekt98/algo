import java.io.*;
import java.util.*;

public class Main {
	static int INF=100000000;
	static int n,m,k;
	static ArrayList<Integer>[] con, dis;
	static int[][] map;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		con = new ArrayList[n+1];
		dis = new ArrayList[n+1];
		map = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			con[i] = new ArrayList<Integer>();
			dis[i] = new ArrayList<Integer>();
			Arrays.fill(map[i], INF);
			map[i][i]=0;
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[u][v]=0;
			if(b==0) map[v][u]=1;
			else map[v][u]=0;
		}
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				if(k==i) continue;
				for(int j=1; j<=n; j++) {
					if(k==j || i==j) continue;
					if(map[i][j]>map[i][k]+map[k][j])
						map[i][j]=map[i][k]+map[k][j];
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(map[s][e]).append('\n');
		}
		
		System.out.println(sb);
	}
}
