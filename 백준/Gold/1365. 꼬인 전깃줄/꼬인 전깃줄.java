import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, line[], dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		line = new int[n+1]; dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=1; i<=n; i++) {
			line[i] = Integer.parseInt(st.nextToken()); 
		}
		
		dp[1]=line[1]; int idx=1;
		for(int i=2; i<=n; i++) {
			if(dp[idx]<line[i]) {
				dp[++idx]=line[i];
			}
			else {
				int index = Arrays.binarySearch(dp, 1, idx, line[i]);
				if(index<0) index = -1*(index+1);
				dp[index]=line[i];
			}
//			System.out.println(Arrays.toString(dp));
		}
		System.out.println(n-idx);
	}
}