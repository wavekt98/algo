import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, ppl[], dp[][];
	static ArrayList<Integer>[] connection,tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		ppl = new int[n+1]; dp = new int[2][n+1];
		connection = new ArrayList[n+1]; tree = new ArrayList[n+1];
		
		Arrays.fill(dp[0], -1);
		Arrays.fill(dp[1], -1);
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			connection[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
			ppl[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			connection[a].add(b); connection[b].add(a);
		}
		
		setTree(1,-1);
		int ans1 = filldp(0,1);
		int ans2 = filldp(1,1);
		System.out.println(Math.max(ans1, ans2));
	}
	static int filldp(int select, int cur) {
		if(dp[select][cur]!=-1) return dp[select][cur];
		if(tree[cur].isEmpty()) {
			if(select==1) dp[select][cur]=ppl[cur];
			else dp[select][cur]=0;
		}
		if(select==1) {
			int sum=0;
			for(int i=0; i<tree[cur].size(); i++) 
				sum+=filldp(0,tree[cur].get(i));
			dp[select][cur]=sum+ppl[cur];
		}
		else {
			int sum=0;
			for(int i=0; i<tree[cur].size(); i++) 
				sum+=Math.max(filldp(0,tree[cur].get(i)),filldp(1,tree[cur].get(i)));
			dp[select][cur]=sum;
		}
		return dp[select][cur];
	}
	static void setTree(int cur, int par) {
		for(int i=0; i<connection[cur].size(); i++) {
			if(connection[cur].get(i)==par) continue;
			tree[cur].add(connection[cur].get(i));
			setTree(connection[cur].get(i),cur);
		}
	}
}
