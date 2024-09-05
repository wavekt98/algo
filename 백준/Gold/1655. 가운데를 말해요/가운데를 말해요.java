import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	static int n;
	static PriorityQueue<Integer> bigger = new PriorityQueue<>();
	static PriorityQueue<Integer> smaller = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
	});
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(i==0) smaller.offer(num);
			else {
				if(smaller.peek()>num) smaller.offer(num);
				else bigger.offer(num);
				checkHeap();
			}
			sb.append(smaller.peek()).append('\n');
		}
		System.out.println(sb);
		
	}
	static void checkHeap() {
		if(smaller.size()+1==bigger.size()) {
			int num = bigger.poll();
			smaller.offer(num);
		}
		else if(smaller.size()==bigger.size()+2) {
			int num = smaller.poll();
			bigger.offer(num);
		}
	}
}