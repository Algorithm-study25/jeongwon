import java.util.Scanner;
public class Practice36 {//백준 P1541

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		String[] str = input.split("-");
		
		int answer = 0;
		for(int i = 0; i < str.length; i++) {
			int temp = plus_sum(str[i]);
			if(i == 0)
				answer = answer + temp;
			else
				answer = answer - temp;
		}
		System.out.println(answer);
		
		sc.close();
	}
	static int plus_sum(String a) {
		int sum = 0;
		
		String temp[] = a.split("\\+"); //+앞에 역슬래시 두개 붙여줘야함
		for(int i = 0; i < temp.length; i++) {
			sum += Integer.parseInt(temp[i]);
		}
		return sum;
	}

}
