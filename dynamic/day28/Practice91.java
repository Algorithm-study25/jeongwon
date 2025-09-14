import java.util.Scanner;
public class Practice91 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		long[][] D = new long [1001][1001];
		
		long max = 0;
		for(int i = 0; i < n; i++) {
			String line = sc.next();
			for(int j = 0; j < m; j++) {
				D[i][j] = Long.parseLong(String.valueOf(line.charAt(j)));
				if(D[i][j] == 1 && i > 0 && j > 0) {
					D[i][j] = Math.min(D[i - 1][j - 1], Math.min(D[i - 1][j],D[i][j - 1])) + D[i][j];
				}
				if(max < D[i][j]) {
					max = D[i][j];
				}
			}
		}
		
		long area = max * max;
		System.out.println(area);

		sc.close();
	}

}
