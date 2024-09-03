package value;

public class Main03 {

	public static void main(String[] args) {
		// 일반 변수
		int width = 100; 
		// 상수
		final double PI = 3.14D;
		
		System.out.println("width = " + width);
		System.out.println("PI = " + PI);
		
		// 값의 변경
		width = 200; 
		// 상수를 재할당 하려고 했으므로 오류 발생
//		PI = 3.141582D;
		
		System.out.println("width = " + width);
		System.out.println("PI = " + PI);
	}

}
