import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice80 {

	public static void main(String[] args) throws IOException{
		int M, K, T; //색의 종류, 선택 조약 돌 개수, 테스트 개수
		int D[] = new int[51];
		double probability[] = new double[51];
		double answer;
		T = 0;
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < M; i++) {
			D[i] = Integer.parseInt(st.nextToken());
			T += D[i];
		}
		st = new StringTokenizer(bf.readLine());
		K = Integer.parseInt(st.nextToken());
		answer = 0.0;
		for(int i = 0; i < M; i++) {
			if(D[i] >= K) {
				probability[i] = 1.0;
				for(int k = 0;k < K; k++) {
					probability[i] *= (double)(D[i] - k) / (T - k);
				}
				answer += probability[i];
			}
		}
		System.out.println(answer);		
	}
}
