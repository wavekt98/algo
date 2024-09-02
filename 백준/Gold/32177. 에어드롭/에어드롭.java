import java.io.*;
import java.util.*;

public class Main {
	static int n, k, t;
	static int[][] ppl;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static boolean[] visit;
	static Queue<Integer> q = new ArrayDeque<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		ppl = new int[n+1][4];
		visit = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		ppl[0][0] = Integer.parseInt(st.nextToken());
		ppl[0][1] = Integer.parseInt(st.nextToken());
		ppl[0][2] = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				ppl[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		if(list.isEmpty()) System.out.println(0);
		else {
			Collections.sort(list);
			for(int i=0; i<list.size(); i++) {
				System.out.print(list.get(i)+" ");
			}
		}
	}
	static void bfs() {
		visit[0]=true;
		q.offer(0);
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(ppl[cur][3]==1) {
				list.add(cur);
			}
			
			for(int i=0; i<=n; i++) {
				if(visit[i]) continue;
				int x = ppl[cur][0]-ppl[i][0];
				int y = ppl[cur][1]-ppl[i][1];
				double dist = Math.sqrt(x*x+y*y);
				int verdiff = Math.abs(ppl[cur][2]-ppl[i][2]);
				if(dist<=k && verdiff<=t) {
					visit[i]=true;
					q.offer(i);
				}
			}
		}
	}
}