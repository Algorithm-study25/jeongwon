package practice30;

import java.util.Scanner;

public class Practice30 {//백준 P2343_블루레이

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //레슨 개수
		int M = sc.nextInt(); // 블루레이 개수
		
		int[]A = new int[N]; //레슨 데이터 저장 배열
		int start = 0;
		int end = 0;
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
			if(start < A[i]) //레슨 최대값을 시작 인덱스로 저장
				start = A[i];
			end = end + A[i];	//모든 레슨의 총합을 종료 인덱스로 저장
		}
		while(start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;
			int count = 0;
			for(int i = 0; i < N; i++) {
				if(sum + A[i] > mid) {
					count++;
					sum = 0;
				}
				sum = sum + A[i];
			}
			if(sum != 0)
				count++;
			if(count > M)
				start = mid + 1;
			else
				end = mid - 1;
		}
		System.out.println(start);
		sc.close();
	}

}
