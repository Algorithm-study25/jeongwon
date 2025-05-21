import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Practice34 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //카드 묶음의 수
		
		PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder()); //양수는 내림차순
		PriorityQueue<Integer> minusPq = new PriorityQueue<>(); //음수는 내림차순 -> 작은 숫자끼리 즉, 음수 중에서 절댓값이 큰 것들끼리 묶어야하므로
		
		int one = 0;
		int zero = 0;
		
		for(int i = 0; i < N; i++) { //4개의 그룹으로 분리
			int data = sc.nextInt();
			if(data > 1) {
				plusPq.add(data);
			}else if(data == 1) {
				one++;
			}else if(data == 0) {
				zero++;
			}else {
				minusPq.add(data);
			}			
		}
		int sum = 0;
		
		//양수 처리
		while(plusPq.size() > 1) {
			int first = plusPq.remove();
			int second = plusPq.remove();
			sum = sum + first * second;
		}
		if(!plusPq.isEmpty()) {
			sum = sum + plusPq.remove();
		}
		
		//음수 처리
		while(minusPq.size() > 1) {
			int first = minusPq.remove();
			int second = minusPq.remove();
			sum = sum + first * second;
		}
		if(!minusPq.isEmpty()) {
			if(zero == 0) {
				sum = sum + minusPq.remove();
			}
		}
		
		sum = sum + one;
		System.out.println(sum);
				
		sc.close();
	}

}
