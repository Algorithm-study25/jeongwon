import java.util.Scanner;
public class Practice15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[]A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		int tmp = 0;
		for(int i = 0; i< N - 1; i++) {
			int swap = 0;
			for(int j = 0; j < N - i - 1; j++) {
				if(A[j] > A[j + 1]) {
					tmp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = tmp;
					swap++;
				}
			}
			if(swap == 0) {
				break;
			}
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println(A[i]);
		}
		
		sc.close();
	}
}
