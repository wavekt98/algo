import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, synergy[], dp[][];
	static ArrayList<Integer>[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		synergy = new int[n+1]; dp = new int[2][n+1];
		tree = new ArrayList[n+1];
		
		Arrays.fill(dp[0], -1);
		Arrays.fill(dp[1], -1);
		
		for(int i=1; i<=n; i++) 
			tree[i] = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=2; i<=n; i++) {
			int a = Integer.parseInt(st.nextToken());
			tree[a].add(i);
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) 
			synergy[i] = Integer.parseInt(st.nextToken());
		
		int ans1 = filldp(0,1);
		int ans2 = filldp(1,1);
		System.out.println(Math.max(ans1, ans2));
	}
	static int filldp(int select, int cur) {
		if(dp[select][cur]!=-1) return dp[select][cur];
		dp[select][cur]=0;
		if(select==0) {
			for(int i=0; i<tree[cur].size(); i++) 
				dp[select][cur]+=Math.max(filldp(0,tree[cur].get(i)),filldp(1,tree[cur].get(i)));
		}
		else {
			int tmp=0,max=0;
			for(int i=0; i<tree[cur].size(); i++) {
				tmp += filldp(1,tree[cur].get(i));
			}
			for(int i=0; i<tree[cur].size(); i++) {
				max = Math.max(max, synergy[cur]*synergy[tree[cur].get(i)]-filldp(1,tree[cur].get(i))+filldp(0,tree[cur].get(i)));
			}
			dp[select][cur]=Math.max(dp[select][cur], tmp+max);
		}
		return dp[select][cur];
	}
}