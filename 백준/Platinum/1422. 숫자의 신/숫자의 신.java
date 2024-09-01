import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int n,k;
	static ArrayList<String> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++)
			list.add(br.readLine());
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int len1=o1.length();
				int len2=o2.length();
				if(len1!=len2) return (len2-len1);
				for(int i=0; i<len1; i++) 
					if(o1.charAt(i)!=o2.charAt(i)) return o2.charAt(i)-o1.charAt(i);
				return 0;
			}
		});
		
		for(int i=n; i<k; i++)
			list.add(list.get(0));
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String s1=o1.concat(o2);
				String s2=o2.concat(o1);
				for(int i=0; i<s1.length(); i++)
					if(s1.charAt(i)!=s2.charAt(i)) return s2.charAt(i)-s1.charAt(i);
				return 0;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(String num:list)
			sb.append(num);
		System.out.println(sb);
	}
}