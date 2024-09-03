package multiex;

public class Main02 {
	public static void main(String[] args) {
		// 1부터 100사이의 정수중에
		// 짝수의 합과, 홀수의 합을 각각 구하여라
		int sumEven = 0; // 짝수
		int sumOdd = 0; // 홀수
		
		for(int i=1; i<=100; i++) {
			if(i%2 == 0) {
				sumEven += i;
			}else {
				sumOdd += i;
			}
		}
		System.out.println("1부터 100사이 홀수의 합 = " + sumOdd);
		System.out.println("1부터 100사이 짝수의 합 = " + sumEven);
	}
}
