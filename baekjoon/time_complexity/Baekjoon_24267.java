import java.util.Scanner;
public class Baekjoon_24267 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long N = sc.nextInt();
				
		System.out.println((N*(N-1)*(N-2)/6));
		System.out.println("3");
		
		sc.close();
	}

}
