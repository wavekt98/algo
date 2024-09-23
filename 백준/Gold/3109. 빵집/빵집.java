import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,c,count=0,max=0;
	static char[][] map;
	static int[] move = {-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[n][c];
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<c; j++)
				map[i][j] = line.charAt(j);
		}
		
		for(int i=0; i<n; i++) {
			map[i][0]='x';
			count+=dfs(i,0);
		}
		
		
		System.out.println(count);
	}
	static int dfs(int row, int col) {
		if(col==c-1) {
			return 1;
		}
		int result=0;
		for(int i : move) {
			if(inRange(row+i) && map[row+i][col+1]!='x') {
				map[row+i][col+1]='x';
				result = dfs(row+i,col+1);
				if(result==1)
					return 1;
			}
		}
		return 0;
	}
	static boolean inRange(int row) {
		if(row<0 || row>=n) return false;
		return true;
	}
}