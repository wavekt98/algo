import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[] seul;
	static ArrayList<Integer> count = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int start = 1;
		int end = 0;
		seul = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			seul[i] = Integer.parseInt(st.nextToken());
			start = Math.max(start, seul[i]);
			end += seul[i];
		}
		
		while(start<=end) {
			int mid = (start+end)/2;
			int tmp = grouping(mid);
			
			if(tmp<=m) end=mid-1;
			else start=mid+1;
		}
		getSubunit(start);

		System.out.println(start);
		for(int i=0; i<m; i++)
			System.out.print(count.get(i)+" ");
	}
	static int grouping(int cut) {
		int sum=0,group=1;
		for(int i=0; i<n; i++) {
			sum+=seul[i];
			if(sum>cut) {
				sum=seul[i];
				group++;
			}
		}
		return group;
	}
	static void getSubunit(int cut) {
		int tmp=m;
		int cnt=0, sum=0;
		int idx;
		for(idx=0; idx<n; idx++) {
			sum+=seul[idx];
			if(sum>cut) {
				tmp--;
				sum=seul[idx];
				cnt = (cnt==0? 1:cnt);
				count.add(cnt);
				cnt=0;
			}
			cnt++;
			if(tmp==n-idx) break;
		}
		for(; idx<n; idx++) {
			count.add(cnt);
            cnt = 1;
		}
		count.add(cnt);
	}
}