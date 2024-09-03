package method;

public class Main03 {

	public static void main(String[] args) {
		// 리턴값을 출력에 사용
		System.out.println( plus(1,2) );
		// 리턴값을 변수에 저장
		int result = plus(2, 3);
		System.out.println(result);
	}

	public static int plus(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}
	
}










