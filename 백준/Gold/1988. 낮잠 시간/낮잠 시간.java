import java.io.*;
import java.util.*;

public class Main {
	static int n,b;
	static int[] recover;
	static int[][][] dp;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		recover = new int[n]; dp = new int[n][b+1][3];
		
		for(int i=0; i<n; i++) {
			recover[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0][0][0]=0;
		dp[0][0][1]=-1000000;
		dp[0][0][2]=0;//0은 시작점 1은 연속된 상태 2는 미선택
		for(int i=0; i<n; i++) {
			for(int j=0; j<=b; j++) {
				Arrays.fill(dp[i][j],-1);
			}
		}
		
		int ans = Math.max(filldp(n-1,b,0),Math.max(filldp(n-1,b,1), filldp(n-1,b,2)));
		System.out.println(ans);
	}
	static int filldp(int cur, int choose, int state) {
		if(cur<0 || choose<=0) return -1000000;
		if(dp[cur][choose][state]!=-1) return dp[cur][choose][state];
		
		dp[cur][choose][state]=0;
		if(state==0) {
			int tmp = filldp(cur-1,choose-1,2);
			dp[cur][choose][0] = Math.max(dp[cur][choose][0], tmp);
		}
		else if(state==1) {
			int tmp = Math.max(filldp(cur-1,choose-1,1)+recover[cur], 
								filldp(cur-1,choose-1,0)+recover[cur]);
			dp[cur][choose][1] = Math.max(dp[cur][choose][1], tmp);
		}
		else {
			int tmp = Math.max(filldp(cur-1,choose,1), filldp(cur-1,choose,0));
			tmp = Math.max(tmp, filldp(cur-1,choose,2));
			dp[cur][choose][2] = Math.max(dp[cur][choose][2], tmp);
		}
//		System.out.println(cur+" "+choose+" "+state+"\t"+dp[cur][choose][state]);
		return dp[cur][choose][state];
	}
}