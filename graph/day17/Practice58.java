import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Practice58 {

	public static void main(String[] args) throws IOException{
		int N, M, K;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		List<List<Edge>> graph = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Edge(v, w));
		}
		
		PriorityQueue<Integer>[] dist = new PriorityQueue[N + 1];
		for(int i = 1; i <= N; i++) {
			dist[i] = new PriorityQueue<>(Collections.reverseOrder());
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));
		dist[1].add(0);
		
		while(!pq.isEmpty()) {
			Edge current = pq.poll();
			int to = current.to;
			int cost = current.weight;
			
			for(Edge next : graph.get(to)) {
				int nextNode = next.to;
				int nextCost = cost + next.weight;
				
				if(dist[nextNode].size() < K) {
					dist[nextNode].add(nextCost);
					pq.offer(new Edge(nextNode, nextCost));
				}else if(dist[nextNode].peek() > nextCost) {
					dist[nextNode].poll();
					dist[nextNode].add(nextCost);
					pq.offer(new Edge(nextNode, nextCost));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			if(dist[i].size() < K) {
				sb.append("-1\n");
			}else {
				sb.append(dist[i].peek()).append("\n");
			}
		}
		
		System.out.print(sb);
		br.close();
		
		
		
		
		
	}
	
	static class Edge implements Comparable<Edge>{
		int to;
		int weight;
		
		public Edge(int to, int weight){
			this.to = to;
			this.weight = weight;			
			
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

}