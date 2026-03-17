import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
public class Practice43 {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		long result = gcd(a, b);
		
		while(result > 0) {
			bw.write("1");
			result--;
		}
		
		sc.close();
		bw.flush();
		bw.close();
	}
	public static long gcd(long a, long b) {
		if(b == 0)
			return a; 
		else
			return gcd(b, a % b);
	}

}
