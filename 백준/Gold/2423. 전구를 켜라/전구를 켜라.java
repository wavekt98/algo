import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static final int INF=250000;
	static int n,m,min=INF;
	static int[][] map;
	static int[][] vertex;
	static int[][] near = {{0,0},{-1,0},{-1,-1},{0,-1}}; // 격자점 기준 \/
	static int[][] move = {{1,1},{-1,1},{-1,-1},{1,-1}}; // \0 /1
	static Deque<int[]> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        vertex = new int[n+1][m+1]; 
        
        for(int i=0; i<=n; i++) {
        	for(int j=0; j<=m; j++) {
        		vertex[i][j]=INF;
        	}
        }
        // (i,j)점과 연결된 선은 
        //(i-1,j-1) (i-1,j)
        //(i,j-1) 	(i,j)
        for(int i=0; i<n; i++) {
        	String line = br.readLine();
        	for(int j=0; j<m; j++) {
        		char cur = line.charAt(j);
        		if(cur=='/') map[i][j] = 1;
        		else	map[i][j] = 0;
        	}
        }
        
        if(n%2!=m%2)
        	System.out.println("NO SOLUTION");
        else {
        	bfs();
        	System.out.println(min);
        }
	}
	static void bfs() {
		q.offer(new int[] {0,0,0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
//			System.out.println(Arrays.toString(cur));
			if(cur[0]==n && cur[1]==m) {
				min=cur[2];
				return;
			}
			for(int n=0; n<4; n++) {
				int ni=cur[0]+near[n][0];
				int nj=cur[1]+near[n][1];
				if(inRange(ni,nj)) {
					if(n%2 == map[ni][nj]) {
						int mi=cur[0]+move[n][0];
						int mj=cur[1]+move[n][1];
						if(vertex[mi][mj]>cur[2]) {
							vertex[mi][mj]=cur[2];
							q.offerFirst(new int[] {mi,mj,cur[2]});
						}
					}
					else {
						int mi=cur[0]+move[n][0];
						int mj=cur[1]+move[n][1];
						if(vertex[mi][mj]>cur[2]+1) {
							vertex[mi][mj]=cur[2]+1;
							q.offerLast(new int[] {mi,mj,cur[2]+1});
						}
					}
				}
			}
		}
	}
	static boolean inRange(int i, int j) {
		return (i>=0 && i<n && j>=0 && j<m);
	}
}
