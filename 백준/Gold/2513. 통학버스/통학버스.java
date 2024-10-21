import java.io.*;
import java.util.*;

public class Main {
	static int n,k,s;
	static PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return Math.abs(o2[0]-s)-Math.abs(o1[0]-s);
		}
	});
	static PriorityQueue<int[]> pq2 = new PriorityQueue<int[]>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return Math.abs(o2[0]-s)-Math.abs(o1[0]-s);
		}
	});
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a<s)
				pq1.offer(new int[] {a,b});
			else
				pq2.offer(new int[] {a,b});
		}
		
		int dist=0;
		while(!pq1.isEmpty()) {
			int[] cur = pq1.poll();
			if(cur[1]>k) {
				dist+=(cur[1]/k)*(Math.abs(cur[0]-s))*2;
				cur[1]%=k;
				if(cur[1]==0) continue;
			}
			int tmp=cur[1];
			while(tmp<k && !pq1.isEmpty()) {
				int[] next = pq1.poll();
				if(k-tmp<next[1]) {
					next[1]-=(k-tmp);
					pq1.offer(new int[] {next[0],next[1]});
					break;
				}
				else {
					tmp+=next[1];
				}
			}	
			dist+=(Math.abs(cur[0]-s))*2;
//			System.out.println(dist);
		}
		
		while(!pq2.isEmpty()) {
			int[] cur = pq2.poll();
			if(cur[1]>k) {
				dist+=(cur[1]/k)*(Math.abs(cur[0]-s))*2;
				cur[1]%=k;
				if(cur[1]==0) continue;
			}
			int tmp=cur[1];
			while(tmp<k && !pq2.isEmpty()) {
				int[] next = pq2.poll();
				if(k-tmp<next[1]) {
					next[1]-=(k-tmp);
					pq2.offer(new int[] {next[0],next[1]});
					break;
				}
				else {
					tmp+=next[1];
				}
			}	
			dist+=(Math.abs(cur[0]-s))*2;
//			System.out.println(dist);
		}
		System.out.println(dist);
	}

}
