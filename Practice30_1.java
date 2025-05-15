package practice30_1;

import java.util.Scanner;

public class Practice30_1 {//백준 2512번

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //지방의 수
		int[]A = new int[N]; //각 지방 필요 예산 저장 배열
		
		int start = 0;
		int end = 0;
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
			if(end < A[i]) 
				end = A[i];	
		}
		
		int M = sc.nextInt(); //총 예산안
		
		while(start <= end) {
			int mid = (start + end) / 2;
			long sum = 0; //budget
			for(int i = 0; i < N; i++) {
				if(A[i] > mid) {
					sum += mid; //상한액을 배정
				}else
					sum += A[i]; //요청한 금액을 그대로 배정한다.
			}
			if(sum <= M)
				start = mid + 1;
			else
				end = mid - 1;
		}
		System.out.println(end);
		
		sc.close();
	}
}
