import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,k,gooseul[],dp[][][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		gooseul = new int[n]; dp = new int[n][n][k+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) 
			gooseul[i] = Integer.parseInt(st.nextToken());

		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				Arrays.fill(dp[i][j], -1);
		
		System.out.println(filldp(0,n-1,0));
	}
	static int filldp(int left, int right, int same) { // same=앞쪽부터 세어온 시작과 같은색의 개수
		if(left>right) return 0;
		if(left==right) return dp[left][right][same]= (k-same-1)>0? k-same-1:0;
		if(dp[left][right][same]!=-1) return dp[left][right][same];
		
		dp[left][right][same]=10000;
		// 뒤쪽 같은색 고려하지 않고 중간에 잘라서 확인
		for(int i=left; i<right; i++) 
			dp[left][right][same]=Math.min(dp[left][right][same], 
					filldp(left,i,same)+filldp(i+1,right,0));
		
		//중간에 같은색 있으면 left+1 ~ i-1 그 사이에 있는 구슬 고려, 같은색+1 하고 뒤쪽 고려
		for(int i=left+1; i<=right; i++)
			if(gooseul[left]==gooseul[i]) 
				dp[left][right][same]=Math.min(dp[left][right][same],
						filldp(left+1,i-1,0)+filldp(i,right,Math.min(same+1, k)));
//		System.out.println(left+" "+right+" "+same+"\t"+dp[left][right][same]);
		return dp[left][right][same];
	}
}