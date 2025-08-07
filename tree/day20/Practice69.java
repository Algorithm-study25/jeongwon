import java.util.Scanner;
public class Practice69 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		Node root = new Node();
		while(N > 0) {
			String text = sc.next();
			Node now = root;
			for(int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);
				if(now.next[c - 'a'] == null) {
					now.next[c - 'a'] = new Node();
				}
				now = now.next[c - 'a'];
				if(i == text.length() - 1)
					now.isEnd = true;
			}
			N--;
		}
		int count = 0;
		while(M > 0) {
			String text = sc.next();
			Node now = root;
			for(int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);
				if(now.next[c - 'a'] == null) {
					break;
				}
				now = now.next[c - 'a'];
				if(i == text.length() - 1 && now.isEnd)
					count++;
			}
			M--;
		}
		System.out.println(count);		
		sc.close();
	}

}

class Node{
	Node[] next = new Node[26];
	boolean isEnd;
}
