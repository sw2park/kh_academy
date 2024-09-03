package loop;

public class Main01 {
	public static void main(String[] args) {
		int sum = 0;
		
		for(int i=1; i<=100; i++) {
			sum +=i;
			System.out.println("sum : " + sum + ", i : " + i);
		}
			System.out.println("결과 값 : " + sum);
	}
}
