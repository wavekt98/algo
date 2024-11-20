import java.io.*;
import java.util.*;

public class Main {
	static int q;
	static int min = Integer.MAX_VALUE;
	static int[] door;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		q = Integer.parseInt(br.readLine());
		door = new int[q];
		for(int i=0; i<q; i++) {
			door[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(0,a,b,0);
		System.out.println(min);
	}
	static void dfs(int cnt, int a, int b, int sum) {
		if(cnt==q) {
			min = Math.min(min, sum);
			return ;
		}
		int target = door[cnt];
		if(target<a) {
			dfs(cnt+1, target, b, sum+Math.abs(target-a));
		}
		else if(target>b) {
			dfs(cnt+1, a, target, sum+Math.abs(target-b));
		}
		else {
			dfs(cnt+1, a, target, sum+Math.abs(target-b));
			dfs(cnt+1, target, b, sum+Math.abs(target-a));
		}
	}
}