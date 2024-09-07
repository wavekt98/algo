import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int g,p,count=0;
	static int[] gate;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		g = Integer.parseInt(br.readLine());
		p = Integer.parseInt(br.readLine());

		gate = new int[g+1];
		for(int i=1; i<=g; i++)
			gate[i]=i;
		for(int i=0; i<p; i++) {
			int next = Integer.parseInt(br.readLine());
			int finalgate = find(next);
			if(finalgate==0)
				break;
			gate[finalgate]--; count++;
//			System.out.println(next);
		}
		System.out.println(count);
	}
	static int find(int a) {
		if(gate[a]==a) return a;
		return gate[a]=find(gate[a]);
	}
	
}
