import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] map,dp;
	static int move[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		dp = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				dp[i][j] = -1;
			}
		}
		int ans = dfs(0,0);
		
//		show();
		System.out.println(ans);
	}
	static int dfs(int i, int j) {
		if(i==n-1 && j==m-1) {
			return 1;
		}
		if(dp[i][j]!=-1) return dp[i][j];
		dp[i][j]=0;
		for(int[] m:move) {
			int ni=i+m[0];
			int nj=j+m[1];
			if(inRange(ni, nj) && map[ni][nj]<map[i][j]) {
				dp[i][j] += dfs(ni,nj);
			}
		}
		return dp[i][j];
	}
	static void show() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}
	static boolean inRange(int i, int j) {
		return (i>=0 && i<n && j>=0 && j<m);
	}
}
