import java.util.Scanner;
public class Practice42 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n =  sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int result = 0;
			result = a * b / gcd(a, b);
			System.out.println(result);
		}
		
		
		sc.close();
	}
	public static int gcd(int a, int b) {
		int remainder = b;
		
		while(remainder != 0) {
			remainder = b % a;
			b = a;
			a = remainder; 
		}
		
		return b;
	}

}
