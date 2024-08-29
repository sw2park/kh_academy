package loop;

public class Main05 {
	public static void main(String[] args) {
		/*
		 * while문으로 구구단 7단 결과 출력
		 * console
		 * 7
		 * 14
		 * 21
		 * ...
		 * 63 
		 */
		
		// 내가 작성한 것
//		int i=1;
//		
//		while(i<10) {
//			System.out.println("7 * "+i+" = "+7*i);
//			i++;
//		}
		
		//강사쌤이 작성한 것
		int i = 1;
		int result = 0;
		
		while(i<10) {
			result = 7 * i;
			System.out.println(result);
			i++;
		}
	}
}