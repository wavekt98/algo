import java.io.*;
import java.util.*;

public class Main {
	static int n,k;
	static Stack<Integer> s = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		String num = br.readLine();
		for(int i=0; i<n; i++) {
			int c = num.charAt(i)-'0';
			while(k>0 && !s.isEmpty() && c>s.peek()) {
				s.pop();
				k--;
			}
			s.push(c);
		}
		
		while(k>0) {
			s.pop();
			k--;
		}

		while(!s.isEmpty()) {
			sb.append(s.pop());
		}
		System.out.println(sb.reverse());
	}
}