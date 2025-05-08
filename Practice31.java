package practice31;

import java.util.Scanner;

public class Practice31 {//백준 P1300_k번째수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		long start = 1, end = K;
		long ans = 0;
		
		while(start <= end) {
			long mid = (start + end) / 2;
			long cnt = 0;
			
			for(int i = 1; i <= N; i++) {
				cnt += Math.min(mid / i,  N);
			}
			if(cnt < K) {
				start = mid + 1;
			}else {
				ans = mid;
				end = mid - 1;
			}
		}
		System.out.println(ans);
		sc.close();

	}

}
