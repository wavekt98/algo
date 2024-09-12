import java.io.*;
import java.util.*;

public class Main {
	static int n,l,r,ppl[][];
	static boolean visit[][];
	static ArrayList<ArrayList<int[]>> list;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static Queue<int[]> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		ppl = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				ppl[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day=0;
		while(true) {
			list = new ArrayList<ArrayList<int[]>>();
			visit = new boolean[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(visit[i][j]) continue;
					visit[i][j]=true; 
					list.add(new ArrayList<>());
					list.get(list.size()-1).add(new int[] {i,j});
					q.offer(new int[] {i,j}); 
					check(list.size()-1);
				}
			}
			if(list.size()!=n*n) {
				redistribute();
				day++;
			}
			else break;
		}
		
		System.out.println(day);
	}
	static void check(int group) {
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int[] d:dir) {
				int ni = cur[0]+d[0];
				int nj = cur[1]+d[1];
				if(!isInside(ni,nj)) continue;
				if(visit[ni][nj]) continue;
				int diff = Math.abs(ppl[cur[0]][cur[1]]-ppl[ni][nj]);
				if(isRange(diff)) {
					visit[ni][nj]=true;
					list.get(group).add(new int[] {ni,nj});
					q.offer(new int[] {ni,nj});
				}
			}
		}
	}
	static void redistribute() {
		for(int i=0; i<list.size(); i++) {
			int sum=0;
			
			for(int[] cur:list.get(i)) {
				sum+=ppl[cur[0]][cur[1]];
			}
			int avg = sum/list.get(i).size();
			for(int[] cur:list.get(i)) {
				ppl[cur[0]][cur[1]]=avg;
			}
		}
	}
	static boolean isRange(int diff) {
		return (diff>=l && diff<=r);
	}
	static boolean isInside(int i, int j) {
		return (i>=0 && i<n && j>=0 && j<n);
	}
}
