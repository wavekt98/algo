import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static long d=0,g=0;
	static ArrayList<Integer>[] adj;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		adj = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b); adj[b].add(a);
		}
		
		for(int i=1; i<=n; i++) {
			if(adj[i].size()>=3) {
				g+=gcheck(adj[i].size());
			}
			d+=dcheck(i);
		}
		
		d/=2;
		if(d>g*3) System.out.println("D");
		else if(d<g*3) System.out.println("G");
		else System.out.println("DUDUDUNGA");
	}
	static long gcheck(int n) {
		return 1L*n*(n-1)*(n-2)/6;
	}
	static long dcheck(int n) {
		long cnt=0;
		for(int near:adj[n]) {
			cnt+=1L*(adj[n].size()-1)*(adj[near].size()-1);
		}
		return cnt;
	}
}