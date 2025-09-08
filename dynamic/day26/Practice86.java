import java.util.Scanner;
public class Practice86 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long D[][] = new long[N + 1][2];
		
		D[1][1] = 1; //가장 끝 자리가 1로 끝나는 한자리 수는 '1' 한 개이다.
		D[1][0] = 0;
		
		for(int i = 2; i <= N; i++) {
			D[i][0] = D[i - 1][0] + D[i - 1][1];
			D[i][1] = D[i - 1][0];
		}
		System.out.println(D[N][0] + D[N][1]);
		
		sc.close();
	}

}
