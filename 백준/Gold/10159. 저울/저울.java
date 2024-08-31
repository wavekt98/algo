import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m,compare[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		compare = new int[n][n];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			compare[a][b]=1;
		}
		
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				if(k==i) continue;
				for(int j=0; j<n; j++) {
					if(k==j || i==j) continue;
					if(compare[i][k]!=0 && compare[k][j]!=0)
						compare[i][j]=compare[i][k]+compare[k][j];
				}
			}
		}
		
//		for(int i=0; i<n; i++) {
//			System.out.println(Arrays.toString(compare[i]));
//		}
		
		for(int i=0; i<n; i++) {
			int count=0; 
			for(int j=0; j<n; j++) {
				if(i==j) continue;
				if(compare[i][j]==0 && compare[j][i]==0) count++; 
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}
}
