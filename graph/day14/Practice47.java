
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Practice47 {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] dp;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());

	        graph = new ArrayList[N + 1];
	        dp = new int[N + 1];

	        for (int i = 1; i <= N; i++) {
	            graph[i] = new ArrayList<>();
	        }

	        // 방향 그대로 저장 (A가 B를 신뢰 → A → B)
	        for (int i = 0; i < M; i++) {
	            st = new StringTokenizer(br.readLine());
	            int A = Integer.parseInt(st.nextToken());
	            int B = Integer.parseInt(st.nextToken());
	            graph[B].add(A);
	        }

	        for (int i = 1; i <= N; i++) {
	            visited = new boolean[N + 1];
	            dp[i] = dfs(i);
	            max = Math.max(max, dp[i]);
	        }

	        for (int i = 1; i <= N; i++) {
	            if (dp[i] == max) {
	                System.out.print(i + " ");
	            }
	        }
	}

	static int dfs(int node) {
        visited[node] = true;
        int count = 1;

        for (int next : graph[node]) {
            if (!visited[next]) {
                count += dfs(next);
            }
        }

        return count;
    }
}
