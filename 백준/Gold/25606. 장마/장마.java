import java.io.*;
import java.util.*;

public class Main {
	static int n,m,q,sum[][],eva[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		sum = new int[n+1][2];
		eva = new int[n+1][2];
		
		int idx=0;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			int cur = Integer.parseInt(st.nextToken());
			sum[i][0]=sum[i-1][0]+cur;
			sum[i][1]=sum[i-1][1];
			
			if(eva[i][0]>0) {
				idx-=eva[i][0];
				sum[i][1]+=eva[i][1];
			}
			sum[i][1]+=idx*m;
			int next = i+cur/m+1;
			if(next<=n) {
				eva[next][0]++;
				eva[next][1]+=cur%m;
			}
			idx++;
		}
		
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			int action = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			
			if(action==1) {
				sb.append(sum[day][0]-sum[day][1]).append('\n');
			}
			else {
				sb.append(sum[day][1]-sum[day-1][1]).append('\n');
			}
			
		}
		System.out.println(sb);
		
	}
}