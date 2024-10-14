import java.io.*;

public class Main {
	static long[] ppl = new long[10001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ppl[0]=1; ppl[2]=1;
		for(int i=4; i<=n; i++) {
			for(int j=2; j<=i; j+=2) {
				ppl[i]+=ppl[j-2]*ppl[i-j];
				ppl[i]%=987654321;
			}
		}
		System.out.println(ppl[n]);
	}
}