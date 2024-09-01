import java.io.*;
import java.util.*;

public class Main {
	static int m,f[][],q;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		f = new int[m+1][19];
		for(int x=1; x<=m; x++) {
			f[x][0] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<19; i++) {
			for(int x=1; x<=m; x++) {
				f[x][i] = f[f[x][i-1]][i-1];
			}
		}
		
		q = Integer.parseInt(br.readLine());
		for(int i=1; i<=q; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			sb.append(query(n,x,0)).append('\n');
		}
		System.out.println(sb);
	}
	static int query(int n, int x, int t) {
		if(t>=19) return x;
		if((n|1<<t)==n) return query(n,f[x][t],t+1);
		return query(n,x,t+1);
	}
}