import java.util.Scanner;

public class Practice70 {
	static int[][]tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 버퍼에서 '숫자'만 가져감. (버퍼에는 '\n'이 남음)
		sc.nextLine(); // 남아있는 '\n'을 읽어서 없애주는 역할
		tree = new int[26][2];
		
		for(int i = 0; i < N; i++) {
			String[] temp = sc.nextLine().split(" ");
			int node = temp[0].charAt(0) - 'A';
			char left = temp[1].charAt(0);
			char right = temp[2].charAt(0);
			
			if(left == '.') {
				tree[node][0] = -1;
			}else {
				tree[node][0] = left - 'A';
			}
			
			if(right == '.') {
				tree[node][1] = -1;
			}else {
				tree[node][1] = right - 'A';
			}
		}
		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);
		System.out.println();
		
		sc.close();
	}
	
	public static void preOrder(int now) {
		if(now == -1)
			return;
		
		System.out.print((char)(now + 'A'));
		preOrder(tree[now][0]);
		preOrder(tree[now][1]);
	}
	
	public static void inOrder(int now) {
		if(now == -1)
			return;
		
		inOrder(tree[now][0]);
		System.out.print((char)(now + 'A'));
		inOrder(tree[now][1]);
	}

	public static void postOrder(int now) {
		if(now == -1)
			return;
		
		postOrder(tree[now][0]);
		postOrder(tree[now][1]);
		System.out.print((char)(now + 'A'));
	}
}
