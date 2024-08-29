package loop;

public class Main03 {
	public static void main(String[] args) {
		/*
		 * 구구단 7단 출력
		 * console
		 * 7 * 1 = 7
		 * 7 * 2 = 14
		 * ...
		 * 7 * 9 = 63
		 */
		
		int result = 0;
		
		for(int i=1; i<10; i++) {
			result = 7 * i;
			System.out.println("7 * " + i + " = " + result);
		}
	}
}
