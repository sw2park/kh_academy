package loop;

public class Main02 {
	public static void main(String[] args) {
		/*
		 * 1. 구구단 7단의 결과값만을 출력
		 * console
		 * 7
		 * 14
		 * 21
		 * 35
		 * ...
		 * 63
		 */
		
		// 내가 작성한 것
//		for(int i=1; i<=9; i++)
//			System.out.println(7*i);
//		
//		for(int i=2; i<10; i++) {
//			for(int j=1; j<10; j++) {
//				System.out.println(i + " X " + j + " = " + i*j);
//			}
//			System.out.println();
		
		// 강사쌤이 한 것
		int result = 0;
		for(int i = 1; i<10; i++) {
			result = 7 * i;
			System.out.println(result);
		}
	}
}
