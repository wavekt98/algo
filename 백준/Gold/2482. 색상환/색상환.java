import java.io.*;

public class Main {
	static int DIV=1000000003;
	static long[][] color;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		color = new long[1001][1001];
		for(int i=1; i<=n; i++) {
			color[i][0]=1;
			color[i][1]=i;
		}
		
		for(int i=4; i<=n; i++) 
			for(int j=2; j<=k; j++) 
				color[i][j] = (color[i-2][j-1]+color[i-1][j])%DIV;
		
		System.out.println(color[n][k]);
	}
}