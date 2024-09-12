import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m,name[],dp[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		name = new int[n]; dp = new int[n];
		
		for(int i=0; i<n; i++)
			name[i] = Integer.parseInt(br.readLine());

		int blank = m;
		for(int i=n-2; i>=0; i--) {
			blank = m-name[i];
			int min=dp[i+1]+blank*blank; //무지성 다음줄
			for(int j=i+1; j<n; j++) {
				if(blank<name[j]+1) break;
				if(j==n-1) {min=0; break;}
				blank-=(name[j]+1);
				min = Math.min(min, dp[j+1]+blank*blank);
			}
			dp[i]=min;
		}
		System.out.println(dp[0]);
	}
}
