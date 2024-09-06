import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int division = 1000000007;
	static long color[], hanoi[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		color = new long[1000001]; hanoi = new long[1000001];
		
		hanoi[1]=1; color[1]=3;
		for(int i=2; i<=1000000; i++) {
			hanoi[i]=(hanoi[i-1]*2+1)%division;
			color[i]=(hanoi[i-1]*8+3)%division;
		}
		System.out.println(color[n]);
	}
}