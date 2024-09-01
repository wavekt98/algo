import java.util.*;
import java.io.*;

public class Main {
	static long[] digit = new long[55];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long a = Long.parseLong(st.nextToken())-1;
		Long b = Long.parseLong(st.nextToken());
		
		digit[1]=1;
		for(int i=2; i<55; i++) {
			digit[i]=digit[i-1]*2+pow(i-1);
		}
		
		long acnt=0,bcnt=0;
		for(int i=55; i>=0; i--) {
			long tmp = pow(i);
			if((a|1L<<i)==a) {
				acnt+=(digit[i]+(a-tmp+1));
				a-=tmp;
			}
			if((b|1L<<i)==b) {
				bcnt+=(digit[i]+(b-tmp+1));
				b-=tmp;
			}
//			System.out.println(a+" "+acnt+"\t"+b+" "+bcnt);
		}
		
		
		System.out.println(bcnt-acnt);
	}
	static long pow(int x) {
		if(x==0) return 1;
		if(x==1) return 2;
		long half = pow(x/2);
		if(x%2==0) return half*half*1L;
		else return half*half*2L;
	}
}