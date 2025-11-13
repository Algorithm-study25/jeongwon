import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Practice14 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> MyQueue = new PriorityQueue<>((o1, o2) -> {
			int first_abs = Math.abs((int) o1);
			int second_abs = Math.abs((int) o2);
			if(first_abs == second_abs) 
				return (int)o1 > (int)o2 ? 1 : -1; 
			else 
				return first_abs - second_abs;
			
		});
		
		for(int i = 0; i < N; i++) {
			int request = Integer.parseInt(br.readLine());
			
			if(request == 0) {
				if(MyQueue.isEmpty())
					System.out.println("0");
				else
					System.out.println(MyQueue.poll());
			}else {
				MyQueue.add(request);
			}
		}		
	}
}
