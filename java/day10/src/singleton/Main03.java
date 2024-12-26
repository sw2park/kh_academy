package singleton;

public class Main03 {
	public static void main(String[] args) {
		/*
		 * 싱글톤 객체 사용하기
		 *  - getInstance() 메서드를 사용하여 객체를 리턴받는 형식으로 사용한다.
		 *  - 여러 객체를 리턴 받더라도 모두 하나의 static 객체를 참조하게 되기 때문에 전역 객체 하나만이 메모리에 할당되게 한다.
		 */
		Calc2 c = Calc2.getInstance();
		Calc2 c2 = Calc2.getInstance();
		Calc2 c3 = Calc2.getInstance();
		Calc2 c4 = Calc2.getInstance();
		
		System.out.println(c.plus(100, 200));
		System.out.println(c);
		System.out.println(c2.plus(100, 200));
		System.out.println(c2);
		System.out.println(c3.plus(100, 200));
		System.out.println(c3);
		System.out.println(c4.plus(100, 200));
		System.out.println(c4);
	}
}
