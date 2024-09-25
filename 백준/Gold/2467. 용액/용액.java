import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,liquid[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		liquid = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			liquid[i] = Integer.parseInt(st.nextToken());
		
		int idx1=-1,idx2=-1,diff=Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			int start=i+1; int end=n-1;
			while(start<=end) {
				int mid=(start+end)/2;
				if(liquid[i]+liquid[mid]>0) {
					if(Math.abs(liquid[i]+liquid[mid])<diff) {
						idx1=i; idx2=mid; diff=Math.abs(liquid[i]+liquid[mid]);
//						System.out.println(liquid[idx1]+" "+liquid[idx2]+" "+diff);
					}
					end=mid-1;
				}
				else {
					if(Math.abs(liquid[i]+liquid[mid])<diff) {
						idx1=i; idx2=mid; diff=Math.abs(liquid[i]+liquid[mid]);
//						System.out.println(liquid[idx1]+" "+liquid[idx2]+" "+diff);
					}
					start=mid+1;
				}
			}
		}
		System.out.println(liquid[idx1]+" "+liquid[idx2]);
	}
}
