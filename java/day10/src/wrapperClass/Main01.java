package wrapperClass;

public class Main01 {
	public static void main(String[] args) {
		String a = "20";
		String b = "3.14";
		
		// wrapper 클래스의 가장 중요한 기능은 특정 데이터형의 모양을 하고 있는 문자열을 실제 데이터형을 변환하는 기능
		int num_a = Integer.parseInt(a);
		float num_b = Float.parseFloat(b);
		
		System.out.println(num_a);
		System.out.println(num_b);
		System.out.println("------------------------------------");
		
		// 변환한 값은 사칙연산이 가능하다.
		int v1 = num_a+500;
		float v2 = num_b+500;
		
		System.out.println(v1);
		System.out.println(v2);
		
		// 기본 데이터 형의 객체화
		Integer i = new Integer(100);
		
		// 기본 데이터 형과 객체화된 데이터는 서로 연산이 가능하다.
		int j = i+300;
		System.out.println("j = " + j);
	}
}