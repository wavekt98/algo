import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,ramen[];
	static long money,b,c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		ramen = new int[n];
		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<n; i++)
			ramen[i] = Integer.parseInt(st.nextToken());
		
		if(b>c) {
			for(int i=0; i<=n-3; i++) {
				if(ramen[i+1]>ramen[i+2]) {
					int min=Math.min(ramen[i], ramen[i+1]-ramen[i+2]);
					ramen[i]-=min; ramen[i+1]-=min;
					money+=min*(b+c);
				}
//				System.out.println(Arrays.toString(left));
				if(ramen[i]>0 && ramen[i+1]>0 && ramen[i+2]>0) {
					int min=Math.min(ramen[i], Math.min(ramen[i+1], ramen[i+2]));
					ramen[i]-=min; ramen[i+1]-=min; ramen[i+2]-=min;
					money+=min*(b+2*c);
				}
//				System.out.println(Arrays.toString(left));
				int min=Math.min(ramen[i], ramen[i+1]);
				ramen[i]-=min; ramen[i+1]-=min;
				money+=min*(b+c);
//				System.out.println(Arrays.toString(left));
			}
			int min=Math.min(ramen[n-2], ramen[n-1]);
			ramen[n-2]-=min; ramen[n-1]-=min;
			money+=min*(b+c);
//			System.out.println(Arrays.toString(left));
		}
		
		for(int i=0; i<=n-1; i++) {
			if(ramen[i]>0)
				money+=ramen[i]*b;
		}
		System.out.println(money);
	}
}