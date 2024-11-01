import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, dp[][];
	static ArrayList<Integer>[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		dp = new int[18][n+1]; //log2 100000 = 16.6
		tree = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) 
			tree[i] = new ArrayList<>();
		for(int i=1; i<=17; i++) 
			Arrays.fill(dp[i], -1);
		
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b); tree[b].add(a);
		}
		int ans=Integer.MAX_VALUE;
		for(int i=1; i<=17; i++)
			ans = Math.min(ans, filldp(i,1,-1));
		
		System.out.println(ans);
	}
	static int filldp(int color, int cur, int par) {
		if(dp[color][cur]!=-1) return dp[color][cur];
		
		dp[color][cur]=0;
		for(int idx: tree[cur]) {
			if(idx==par) continue;
			int tmp=1000000;
			for(int i=1; i<=17; i++)
				if(color!=i) 
					tmp = Math.min(tmp, filldp(i,idx,cur));
			dp[color][cur]+=tmp;
		}
		dp[color][cur]+=color;
		return dp[color][cur];
	}
}
