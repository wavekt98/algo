import java.io.*;
import java.util.*;

public class Main {
	static int n, h[], min=Integer.MAX_VALUE;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		h = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(h);
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>i; j--) {
				int start = i+1;
				int end = j-1;
				int elsa = h[i]+h[j];
				
				while(start<end) {
					int anna = h[start]+h[end];
					if(elsa==anna) {
						System.out.println(0);
						return;
					}
					min = Math.min(min, Math.abs(elsa-anna));
					
					if(elsa>anna) start++;
					else end--;
				}
			}
		}
		System.out.println(min);
	}
}