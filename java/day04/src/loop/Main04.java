package loop;

public class Main04 {
	public static void main(String[] args) {
		// 1 + 2 + ... 99 + 100
		
		int sum = 0;
		
		int i = 1;
		while (i<=100) {
			sum += i;
			i++;
			System.out.println("i = " + i + " sum = " + sum);
		}
		System.out.println(sum);
	}
}
