package array;

public class Main01 {

	public static void main(String[] args) {
		// 배열의 생성 방법
		// 배열의 선언과 크기 지정 및 값의 할당에 대한 개별처리
		int[] dooly;
		dooly = new int[3];
		dooly[0] = 75;
		dooly[1] = 82;
		dooly[2] = 91;
			
		// 배열의 선언과 크기 지정의 일괄처리
		int[] doune = new int[3];
		doune[0] = 88;
		doune[1] = 64;
		doune[2] = 50;
		
		// 배열 생성의 일괄처리
		int[] ddochy = new int[] {100, 100, 90};
		
		// 배열의 활용 방법
		int sum1 = 0, sum2 = 0, sum3 = 0;
		
		// sum1 -> 둘리 성적 총합
		for( int i=0; i<dooly.length; i++ ) {
			sum1 += dooly[i];
		}
		System.out.println("둘리 성적 총합 : " + sum1);
		
		// sum2 -> 도우너 성적 총합
		for( int i=0; i<doune.length; i++ ) {
			sum2 += doune[i];
		}
		System.out.println("도우너의 성적 총합 : " + sum2);
		
		// sum3 -> 또치 성적 총합
		for( int i=0; i<ddochy.length; i++ ) {
			sum3 += ddochy[i];
		}
		System.out.println("또치의 성적 총합 : " + sum3);
		
		// 각각의 평균 구하기
		System.out.println(sum1 / dooly.length);
		System.out.println(sum2 / doune.length);
		System.out.println(sum3 / ddochy.length);
	}

}








