package operator; 

public class Main02 {
	public static void main(String[] args) {
		int num1 = 123;
		int num2 = 456;
		
		// 비교연산자에 대한 결과는 boolean 값이다.
		boolean result1 = num1 == num2;
		
		System.out.println(result1);
		
		boolean result2 = num1 != num2;
		System.out.println(result2);
		
		boolean result3 = num1 > num2;
		System.out.println(result3);
		
		boolean result4 = num1 <= num2;
		System.out.println(result4);
	}
}
