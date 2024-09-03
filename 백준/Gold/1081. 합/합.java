import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int start,end,set;
	static long ans=0,cnt[];
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		if(start==0) start=1;
		cnt = new long[10];
		set=1;
		while(start<=end) {
			while(start%10!=0 && start<=end) {
				update(start); start++;
			}
			if(start>end) break;
			while(end%10!=9 && start<=end) {
				update(end); end--;
			}
			
			int diff = end/10-start/10+1;
			for(int i=0; i<10; i++)
				cnt[i]+=diff*set;
			set*=10; start/=10; end/=10;
		}
		for(int i=1; i<10; i++)
			ans+=cnt[i]*i;
		System.out.println(ans);
	}
	static void update(int n) {
		String str = String.valueOf(n);
		for(int i=0; i<str.length(); i++) 
			cnt[str.charAt(i)-'0']+=set;
	}
}