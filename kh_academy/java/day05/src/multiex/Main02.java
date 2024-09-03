package multiex;

public class Main02 {

	public static void main(String[] args) {
		// 1~100 중에서 홀수들의 합
		
		// 무한루프
		// continue; break; 사용해서 홀수들의 합 출력
		
		int sum = 0;
		int i = 0;
		
		while(true) {
			i++;
			if( i % 2 == 0 ) {	// 짝수
				System.out.println(i);
				continue;
			}
			if( i>100 ) {
				break;
			}
			sum += i;
		}
		
		System.out.println(sum);
		
		
	}

}









