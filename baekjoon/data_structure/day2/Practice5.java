import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Practice5 {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		long []S = new long[N];
		S[0] = sc.nextInt();
		for(int i = 1; i < N; i++) {
			S[i] = S[i - 1] + sc.nextInt();
		}
		long []C = new long[M];
		long answer = 0;
		for(int i = 0; i < N; i++) {
			int remainder = (int)(S[i] % M);
			if(remainder == 0)answer++;
			
			C[remainder]++;
		}
		for(int i = 0; i < M; i++) {
			if(C[i] > 1) {
				answer = answer + (C[i] * (C[i]- 1) / 2);
			}
		}
		System.out.println(answer);

	}

}
