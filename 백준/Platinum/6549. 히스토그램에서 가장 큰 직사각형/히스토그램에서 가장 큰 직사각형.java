import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, height[];
	static long max;
	static class SegTree {
		int len;
		int[] tree;
		public SegTree(int[] num) {
			len = n;
			tree = new int[n*4];
			init(0,n-1,1);
		}
		public int init(int start, int end, int idx) {
			if(start==end) return tree[idx] = start;
			int mid = (start+end)/2;
			int front = init(start,mid,idx*2);
			int back = init(mid+1,end,idx*2+1);
			return tree[idx] = height[front]<=height[back]? front:back; 
		}
		public int getIdx(int start, int end, int idx, int a, int b) {
			if(start>b || a>end) return -1;
			if(a<=start && end<=b) return tree[idx];
			
			
			int mid = (start+end)/2;
			int front = getIdx(start,mid, idx*2, a, b);
			int back = getIdx(mid+1,end, idx*2+1, a, b);
			if(front==-1) return back;
			if(back==-1) return front;
			return height[front]<=height[back]? front:back;
		}
		public long getMax(int a, int b) {
			int minidx = getIdx(0,n-1,1,a,b);
			long tmp = 1L*(b-a+1)*height[minidx];
			if(a<minidx) tmp = Math.max(tmp, getMax(a,minidx-1)); 
			if(minidx<b) tmp = Math.max(tmp, getMax(minidx+1,b)); 
			return tmp;
		}
	}
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		while(n!=0) {
			height = new int[n];
			for(int i=0; i<n; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			max=0;
			SegTree segtree = new SegTree(height);
			sb.append(segtree.getMax(0, n-1)).append('\n');
			
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sb);
	}
}