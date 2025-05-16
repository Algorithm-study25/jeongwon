import java.util.PriorityQueue;
import java.util.Scanner;
public class Practice33 {

	public static void main(String[] args) {//P1715번 문제
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //카드 묶음의 수 저장
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			int data = sc.nextInt();
			pq.add(data);
		}
		int data1 = 0;
		int data2 = 0;
		int sum = 0;
		
		while(pq.size() != 1) {//data1,2에는 가장 작은 값 2개가 들어감
			data1 = pq.remove();
			data2 = pq.remove();
			sum += data1 + data2;
			pq.add(data1 + data2);
		}
		System.out.println(sum);
		
		sc.close();
	}
}
