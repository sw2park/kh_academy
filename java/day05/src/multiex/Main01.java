package multiex;

public class Main01 {

	public static void main(String[] args) {
		// 1부터 100사이의 정수중에 
		// 짝수의 합과, 홀수의 합을 각각 구하여라
		int sum1 = 0;
		int sum2 = 0;
		
		for( int i=1; i<=100; i++ ) {
			// 조건식
			if( i%2 == 0 ) {	// 짝수
				sum1 += i;
			} else {			// 홀수
				sum2 += i;
			}
		}
		
		System.out.println("짝수 : " + sum1);
		System.out.println("홀수 : " + sum2);
	}

}










