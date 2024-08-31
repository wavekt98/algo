import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int n, height[];
	static long count=0;
	static Stack<long[]> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		height = new int[n];
		
		for(int i=0; i<n; i++) 
			height[i] = Integer.parseInt(br.readLine());
		
		stack.push(new long[] {height[0],1});
		for(int i=1; i<n; i++) {
			if(stack.peek()[0]>height[i]) {
				count++;
				stack.push(new long[] {height[i],1});
			}
			else if(stack.peek()[0]==height[i]) {
				long[] top = stack.pop();
				count+=top[1];
				if(!stack.isEmpty()) count++;
				stack.push(new long[] {height[i],top[1]+1});
			}
			else { //stack.peek()[0]<height[i]
				while(!stack.isEmpty() && stack.peek()[0]<height[i]) {
					long[] top = stack.pop();
					count+=top[1];
				}
				if(!stack.isEmpty() && stack.peek()[0]==height[i]) {
					long[] top = stack.pop();
					count+=top[1];
					if(!stack.isEmpty()) count++;
					stack.push(new long[] {height[i],top[1]+1});
				}
				else {
					if(!stack.isEmpty()) count++;
					stack.push(new long[] {height[i],1});
				}
			}
//			System.out.println(height[i]+" "+count);
		}
		
		System.out.println(count);
	}

}