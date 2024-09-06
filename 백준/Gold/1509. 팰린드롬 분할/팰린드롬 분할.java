import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static char[] list;
	static int[][] dp;
	static int[] palin;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = br.readLine().toCharArray();
		n = list.length;
		dp = new int[n][n];
		palin = new int[n];
		
		for(int i=0; i<n; i++) {
			dp[i][i]=1;
			if(i>0) dp[i-1][i] = list[i-1]==list[i]? 1:-1;
			if(i>1) dp[i-2][i] = list[i-2]==list[i]? 1:-1;
		}
		
		for(int i=3; i<n; i++) {
			for(int j=i; j<n; j++) {
				dp[j-i][j] = (list[j-i]==list[j] && dp[j-i+1][j-1]==1)? 1:-1;
			}
		}
		
		for(int end=0; end<n; end++) {
			palin[end]=10000;
			for(int start=0; start<=end; start++) {
				if(dp[start][end]==1)
					palin[end]=Math.min(palin[end],start>0? palin[start-1]+1:1);
			}
		}
		
		System.out.println(palin[n-1]);
	}
}