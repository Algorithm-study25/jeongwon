import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Practice7 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A[] = new int[N];		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		int count = 0; 
		int i = 0;
		int j = 1;
		while(i < N - 1) {//N = 6, N - 1= 5
			int sum = A[i] + A[j];
			
			if(sum == M) {
				count++;
				i++;
				j = i + 1;
			}else if(j < N - 1) {
				j++;
			}else {
				i++;
				j = i + 1;
			}
		}
		
		System.out.println(count);
		
		br.close();
	}

}
