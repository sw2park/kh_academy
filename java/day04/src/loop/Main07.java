package loop;

public class Main07 {
	public static void main(String[] args) {
		/*
		 * do~while을 사용해서 구구단 7단의 결과값 출력
		 * console
		 * 7
		 * 14
		 * ...
		 * 63
		 */
		
		int i = 1;
		int result = 0;
		
		do {
			result = i * 7;
			System.out.println("7 * " + i + " = " + result);
			i++;
		}while(i<10);
	}
}
