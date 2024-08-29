package method;

public class Main02 {

	public static void main(String[] args) {
		plus(10, 20);
		plus(20, 30);
		minus(10, 20);
		minus(20, 20);
		minus(30, 10);
		minus(50, 90);
		minus(70, 30);
	}
	
	public static void minus(int num1, int num2) {
		System.out.println(num1 - num2);
	}
	
	// minus라는 이름의, int 타입 파라미터 2개가 정의된
	// 두 파라미터의 뺄셈을 출력해주는 메서드를 정의한 후,
	// main()에서 5번 파라미터값을 각각 바꿔 호출하라
	
	public static void plus(int num1, int num2) {
		int result = num1 + num2;
		System.out.println(result);
	}
	
	
	
	

}








