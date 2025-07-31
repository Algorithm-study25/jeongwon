import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Practice63 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int N, M;
	static int dist[][];
	public static void main(String[] args)throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new int[N + 1][N + 1];
		
		for(int i = 1;i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j)
					dist[i][j] = 0;
				else
					dist[i][j] = 10001;
				
			}
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			dist[s][e] = 1;
			dist[e][s] = 1;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(dist[i][j] > dist[i][k] + dist[k][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
		
		int Min = Integer.MAX_VALUE;
		int Answer = -1;
		for(int i = 1; i <= N; i++) {
			int temp = 0;
			for(int j = 1; j <= N; j++) {
				temp = temp + dist[i][j];
			}
			if(Min > temp) {
				Min = temp;
				Answer = i;
			}
		}
		System.out.println(Answer);

	}

}
