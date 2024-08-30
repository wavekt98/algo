import java.io.*;
import java.util.*;

public class Main {
	static final int DIV=1000000007;
	static int n;
	static long slime[];
	static long energy;
	static PriorityQueue<Long> pq;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int test=1; test<=t; test++) {
			n = Integer.parseInt(br.readLine());
			slime = new long[n];
			pq = new PriorityQueue<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				long s = Long.parseLong(st.nextToken());
				pq.offer(s);
			}
			
			energy=1;
			while (pq.size()>1) {
				long newSlime = (pq.poll() * pq.poll());
				pq.offer(newSlime);
				energy = energy *(newSlime%DIV)%DIV;
			}
			sb.append(energy).append('\n');
		}
		System.out.println(sb);
	}
}