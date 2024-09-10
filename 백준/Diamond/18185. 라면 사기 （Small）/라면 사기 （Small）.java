import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,money,ramen[],left[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ramen = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<n; i++)
			ramen[i] = Integer.parseInt(st.nextToken());
		left = Arrays.copyOf(ramen, n);
		
		for(int i=0; i<=n-3; i++) {
			if(left[i+1]>left[i+2]) {
				int min=Math.min(left[i], left[i+1]-left[i+2]);
				left[i]-=min; left[i+1]-=min;
				money+=min*5;
			}
//			System.out.println(Arrays.toString(left));
			if(left[i]>0 && left[i+1]>0 && left[i+2]>0) {
				int min=Math.min(left[i], Math.min(left[i+1], left[i+2]));
				left[i]-=min; left[i+1]-=min; left[i+2]-=min;
				money+=min*7;
			}
//			System.out.println(Arrays.toString(left));
			int min=Math.min(left[i], left[i+1]);
			left[i]-=min; left[i+1]-=min;
			money+=min*5;
//			System.out.println(Arrays.toString(left));
		}
		int min=Math.min(left[n-2], left[n-1]);
		left[n-2]-=min; left[n-1]-=min;
		money+=min*5;
//		System.out.println(Arrays.toString(left));
		for(int i=0; i<=n-1; i++) {
			if(left[i]>0)
				money+=left[i]*3;
		}
		System.out.println(money);
	}
}