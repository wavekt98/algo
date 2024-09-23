import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, num[], incr[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		while(line != null && line.length()!=0) {
			StringTokenizer st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			num = new int[n]; incr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++)
				num[i] = Integer.parseInt(st.nextToken());
			
			incr[0]=num[0]; int idx=0;
			for(int i=1; i<n; i++) {
				if(incr[idx]<num[i]) {
					incr[++idx]=num[i];
				}
				else {
					int index = Arrays.binarySearch(incr, 0, idx, num[i]);
					if(index<0) index = -1*(index+1);
					incr[index]=num[i];
				}
			}
			
			sb.append(idx+1).append('\n');
			line = br.readLine();
		}
		System.out.println(sb);
	}
}