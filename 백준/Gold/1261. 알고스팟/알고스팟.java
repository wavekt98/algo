import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,min=Integer.MAX_VALUE;
	static int map[][]; 
	static int black[][];
	static boolean visit[][];
	static int move[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static Queue<Room> q = new ArrayDeque<Room>();
	
	static class Room {
		int x;
		int y;
		int change;
		public Room(int x, int y, int change) {
			super();
			this.x = x;
			this.y = y;
			this.change = change;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		black = new int[n][m];
		visit = new boolean[n][m];
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<m; j++)
				map[i][j] = line.charAt(j)-'0';	
		}
		
		bfs();
		System.out.println(min);
	}
	static void bfs() {
		q.offer(new Room(0,0,0));
		black[0][0]=0;
		visit[0][0]=true;
		while(!q.isEmpty()) {
			Room cur = q.poll();
			if(cur.x==n-1 && cur.y==m-1) {
				if(min>cur.change)
					min=cur.change;
				if(min==0)
					return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = cur.x+move[i][0];
				int ny = cur.y+move[i][1];
				if(inRange(nx, ny)) {
					if(map[nx][ny]==0) {
						if(!visit[nx][ny] || (visit[nx][ny] && cur.change<black[nx][ny])) {
							visit[nx][ny] = true;
							black[nx][ny] = cur.change;
							q.add(new Room(nx,ny,cur.change));
						}
					}
					else {
						if(!visit[nx][ny] || (visit[nx][ny] && cur.change+1<black[nx][ny])) {
							visit[nx][ny] = true;
							black[nx][ny] = cur.change+1;
							q.add(new Room(nx,ny,cur.change+1));
						}
					}
				}
			}
		}
	}
	static boolean inRange(int i, int j) {
		if(i<0 || i>=n || j<0 || j>=m)
			return false;
		return true;
	}
}

