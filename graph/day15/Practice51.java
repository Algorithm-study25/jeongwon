import java.util.Scanner;
public class Practice51 {

	public static int[]parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] city = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				city[i][j] = sc.nextInt();
			}
		}
		int[] route = new int[M + 1];
		for(int i = 1; i <= M; i++) {
			route[i] = sc.nextInt();
		}
		parent = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(city[i][j] == 1) union(i, j);
			}
		}
		
		int index = find(route[1]);
		for(int i = 2; i < route.length; i++) {
			if(index != find(route[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		
		sc.close();
	}
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			parent[b] = a;
		}
	}
	public static int find(int a) {
		if(a == parent[a])
			return a;
		else
			return parent[a] = find(parent[a]);
	}
}
