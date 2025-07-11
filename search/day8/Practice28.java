package practice28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Practice28 { //백준 P1167_트리의 지름

	static boolean visited[];
	static int[] distance;
	static ArrayList<Edge>[] A;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		A = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Edge>();
		}
		for(int i = 0; i < N; i++) {
			int S = sc.nextInt();
			while(true) {
				int E = sc.nextInt();
				if(E == -1)
					break;
				int V = sc.nextInt();
				A[S].add(new Edge(E, V));
			}
		}
		distance = new int[N + 1];
		visited = new boolean[N + 1];
		BFS(1);
		int MAX = 1;
		for(int i= 2; i <= N; i++) {
			if(distance[MAX] < distance[i])
				MAX = i;
		}
		distance = new int[N + 1];
		visited = new boolean [N + 1];
		BFS(MAX);
		Arrays.sort(distance);
		System.out.print(distance[N]);
	}
	private static void BFS(int index) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(index);
		visited[index] = true;
		while(!queue.isEmpty()) {
			int now_node = queue.poll();
			for(Edge i : A[now_node]) {
				int e = i.e;
				int v = i.value;
				if(!visited[e]) {
					visited[e] = true;
					queue.add(e);
					distance[e] = distance[now_node] + v;
				}
			}
		}
	}
}

class Edge{
	int e;
	int value;
	public Edge(int e, int value) {
		this.e = e;
		this.value = value;
	}
}
