package loop;

public class Main06 {
	public static void main(String[] args) {
		// 1+2+...+100
		int sum=0;
		int i=1;
		
		do {
			sum += i;
			i++;
		} while(i<=100);
		System.out.println(sum);
	}
}
