import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int v,e;
	static Edge[] edgeList;
	static int[] parents;
	
	static class Edge implements Comparable<Edge>{
		int start,end;
		long weight;
		
		public Edge(int start, int end, long weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
		
		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		parents = new int[v+1];
	    edgeList = new Edge[e];
	    
	    for(int i=0; i<e; i++){
	        st = new StringTokenizer(br.readLine().trim());
	        int from = Integer.parseInt(st.nextToken());
	        int to = Integer.parseInt(st.nextToken());
	        long weight = Long.parseLong(st.nextToken());
	  
		    edgeList[i] = new Edge(from ,to, weight);
	    }
	    for (int i = 0; i < v; i++) {
			parents[i] = i;
		}

	    Arrays.sort(edgeList);
	    long result = 0;
	    int count=0;// 연결 간선수
		for(Edge edge : edgeList){
		  	if(union(edge.start,edge.end)){ // 싸이클이 발생하지 않았으면
		   		result += edge.weight;
		   		if(++count == v-1)	break;
		 	}
		}
		    
		System.out.println(result);
	}
	public static int find(int a){
		if(parents[a] == a) return a;// 자신이 루트이면 그냥 자신의 번호 리턴
		return parents[a] = find(parents[a]);
	}
	public static boolean union(int a,int b){
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		// 두 노드의 root가 다르면 합침
		parents[bRoot] = aRoot;
		return true;
	}	
}
