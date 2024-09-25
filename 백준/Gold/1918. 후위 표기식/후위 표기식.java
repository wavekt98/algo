import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line = sc.next();
		Stack<Character> st = new Stack<Character>();
		String ans = "";
		for(int i=0; i<line.length(); i++) {
			char c = line.charAt(i);
			if(c>='A' && c<='Z')
				ans+=c;
			else {
				if(c=='(')
					st.push(c);
				else if(c==')') {
					while(!st.peek().equals('('))
						ans+=st.pop();
					st.pop();
				}
				else if(c=='*' || c=='/') {
					while(!st.empty() && (st.peek().equals('*') || st.peek().equals('/')))
						ans+=st.pop();
					st.push(c);
				}
				else { //+ -
					while(!st.empty() && !st.peek().equals('('))
						ans+=st.pop();
					st.push(c);
				}
			}
		}
		while(!st.empty())
			ans+=st.pop();
		System.out.println(ans);
	}
}