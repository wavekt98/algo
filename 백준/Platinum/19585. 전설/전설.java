import java.io.*;
import java.util.*;

public class Main {
	static int c,n,q;
	static boolean flag;
	static Set<String> name = new HashSet<>();
	static class Trie{
		Trie child[] = new Trie[26];
		boolean end;
		void insert(String word) {
			Trie cur = this;
			for(int i=0; i<word.length(); i++) {
				int idx = word.charAt(i)-'a';
				if(cur.child[idx]==null) {
					cur.child[idx] = new Trie();
				}
				cur = cur.child[idx];
			}
			cur.end=true;
		}
		boolean search(String word) {
			Trie cur = this;
			for(int i=0; i<word.length(); i++) {
				int idx = word.charAt(i)-'a';
				if(cur.child[idx]!=null) {
					if(cur.child[idx].end && name.contains(word.substring(i+1))) {
						return true;
					}
					cur = cur.child[idx];
				}
				else {
					break;
				}
			}
			return false;
		}
	}
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		Trie color = new Trie();
		
		for(int i=0; i<c; i++) {
			String next = br.readLine();
			color.insert(next);
		}
		for(int i=0; i<n; i++) {
			String next = br.readLine();
			name.add(next);
		}
			
		
		q = Integer.parseInt(br.readLine());
		for(int i=0; i<q; i++) {
			String team = br.readLine();
			if(color.search(team)) sb.append("Yes").append('\n');
			else sb.append("No").append('\n');
		}
		System.out.println(sb);
	}
}