import java.util.*;

class Solution {
    static int INF=20000000;
    static int n;
    static boolean[] visit;
    
    static class Node {
		int idx;
	    int edge;
		public Node(int idx, int edge) {
			super();
			this.idx = idx;
			this.edge = edge;
		}
	}
    static ArrayList<Node>[] graph;
    static PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
		@Override
		public int compare(Node o1, Node o2) {
			return o1.edge-o2.edge;
		}
	});
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n=n;
        
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<fares.length; i++) {
            graph[fares[i][0]].add(new Node(fares[i][1],fares[i][2]));
            graph[fares[i][1]].add(new Node(fares[i][0],fares[i][2]));
        }
        
        int[] start = dijkstra(s);
        int[] froma = dijkstra(a);
        int[] fromb = dijkstra(b);
        
        int answer = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            answer = Math.min(answer, start[i]+froma[i]+fromb[i]);
        }
        return answer;
    }
    static int[] dijkstra(int start) {
		visit = new boolean[n+1];
		int[] dist = new int[n+1];
		Arrays.fill(dist, INF);
		dist[start]=0;
		
		pq.offer(new Node(start,0));
		while(!pq.isEmpty()) {
			Node cur=pq.poll();
			
			if(visit[cur.idx]) continue;
			visit[cur.idx]=true;
			for(Node next:graph[cur.idx]) {
				if(visit[next.idx]) continue;
				if(dist[next.idx]>cur.edge+next.edge) {
					dist[next.idx]=cur.edge+next.edge;
					pq.offer(new Node(next.idx,dist[next.idx]));
				}
			}
		}
		return dist;
	}
}