import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n,m,k;
	static int[] depth;
	static int[][] parent;
	static ArrayList<Integer>[] tree;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		k =-1;
		for(int i=1; i<=n; i*=2)
			k++;
		depth = new int[n+1]; 
		parent = new int[k+1][n+1];
		tree = new ArrayList[n+1];
		for(int i=1; i<=n; i++)
			tree[i] = new ArrayList<>();
		
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b); tree[b].add(a);
		}
		dfs(1,1);
		fill();
		
		m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(lca(a,b)).append('\n');
		}
		System.out.println(sb);
	}
	static void dfs(int idx, int cnt) {
		depth[idx]=cnt;
		int len = tree[idx].size();
		for(int i=0; i<len; i++) {
			int next = tree[idx].get(i);
			if(depth[next]==0) {
				dfs(next,cnt+1);
				parent[0][next]=idx;
			}
		}
	}
	static void fill() {
		for(int i=1; i<=k; i++)
			for(int j=1; j<=n; j++)
				parent[i][j]=parent[i-1][parent[i-1][j]];
	}
	static int lca(int a, int b) {
		if (depth[a] < depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		for (int i = k; i>=0; i--) {
			if (Math.pow(2, i) <= depth[a] - depth[b]) {
				a = parent[i][a];
			}
		}
		if (a == b) return a;
		for (int i = k; i >= 0; i--) {
			if (parent[i][a] != parent[i][b]) {
				a = parent[i][a];
				b = parent[i][b];
			}
		}
		return parent[0][a];
	}
}