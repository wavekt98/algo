import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int f;
	static int[] parent,group;
	static HashMap<String, Integer> user;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=t; test++) {
			f = Integer.parseInt(br.readLine());
			user = new HashMap<>();
			int idx=0;
			
			parent = new int[200010];
			group = new int[200010];
			for(int i=0; i<200010; i++) {
				parent[i]=i;
				group[i]=1;
			}
			
			String name;
			for(int i=0; i<f; i++) {
				st = new StringTokenizer(br.readLine());
				
				name = st.nextToken();
				int a = user.getOrDefault(name, -1);
				if(a==-1) {
					a=idx;
					user.put(name, idx++);
				}
				
				name = st.nextToken();
				int b = user.getOrDefault(name, -1);
				if(b==-1) {
					b=idx;
					user.put(name, idx++);
				}
				sb.append(union(a,b)).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	static int find(int a) {
		if(parent[a]==a) return a;
		return parent[a]=find(parent[a]);
	}
	static int union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
		if(aroot==broot) return group[aroot];
		parent[broot]=aroot; 
		int sum=group[aroot]+group[broot];
		group[aroot]=sum; group[broot]=sum;
		return group[aroot];
	}
}