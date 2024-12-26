package multiex;

public class Main04 {

	public static void main(String[] args) {
		// 1. 이중 for문을 사용해서 구구단 2단~9단까지의
		// 결과값을 출력
		for(int i=2; i<=9; i++) {		// 단에대한 for문
			for(int j=1; j<10; j++) {	// 곱해지는 대상에 대한 for문
				int result = i * j;
				System.out.println(result);
			}
			System.out.println("----------------");
		}
		System.out.println("===========================");
		
		// 2. 이중 while문을 사용해서 구구단 2단~9단까지의
		// 결과값을 출력
		int i=2; 
		int j=1;
		
		while( i <=9 ) {
			while( j < 10 ) {
				System.out.println(i * j);
				j++;
			}
			System.out.println("---------------");
			
			i++;
			j=1;
		}
		
		
	}

}









