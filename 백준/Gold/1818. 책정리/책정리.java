import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, book[], dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        book = new int[n]; dp = new int[n];
        
        st  = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) 
        	book[i] = Integer.parseInt(st.nextToken());
        
        dp[0]=book[0]; int idx=0;	
       	for(int i=1; i<n; i++) {
        	if(dp[idx]<book[i]) {
        		dp[++idx]=book[i];
        	}
        	else {
        		int index = Arrays.binarySearch(dp, 0, idx, book[i]);
        		if(index<0) index=-1*(index+1);
        		dp[index]=book[i];
        	}
		}
       	
       	System.out.println(n-idx-1);
	}
}