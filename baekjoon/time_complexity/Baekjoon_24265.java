import java.util.Scanner;
public class Baekjoon_24265 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long N = sc.nextInt();
		long result = N * (N - 1)/2;
		
		System.out.println(result);
		System.out.println("2");
		
		
		sc.close();
	}

}
