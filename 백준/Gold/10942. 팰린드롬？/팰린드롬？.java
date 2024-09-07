import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			list[i] = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[n][n];
		for(int i=0; i<n; i++) {
			dp[i][i]=1;
			if(i>1) // 3개짜리
				dp[i-2][i]= list[i-2]==list[i]?1:0;
			if(i>0) // 2개짜리
				dp[i-1][i]= list[i-1]==list[i]?1:0;
		}
		for(int i=3; i<n; i++) {
			for(int j=0; j<n-i; j++) {
				if(list[j]==list[j+i] & dp[j+1][j+i-1]==1)
					dp[j][j+i]=1;
				else
					dp[j][j+i]=0;
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			if(dp[start][end]==1) 
				sb.append("1\n");
			else
				sb.append("0\n");
		}
		
		System.out.println(sb);
	}
}