package singleton;

public class Calc2 {
	/*
	 * 공통 기능을 포함할 클래스안에 스스로의 객체를 static 선언
	 *  - static이 적용된 자원은 메모리의 고정영역에 생성되기 때문에, 
	 *  클래스 자체의 객체나 그 안에 포함된 멤버변수, 메서드와는 메모리 상에서 구별된다고 볼 수 있다.
	 *  - 그러므로 Calc2클래스 안에 static 형태로 Calc2 클래스의 객체를 정의하더라도, 
	 *  코드상의 논리적인 연관관계를 위해 하나의 클래스 파일에 정의하는 것일 뿐, 실제로는 Calc 클래스 자체에서 독립된 객체가 되는 것이다.
	 *  - Calc2 클래스 이외의 여러 곳에서 new 연산자를 사용하여 객체 할당이 가능하다면, 
	 *  SingleTon 이라는 개념 자체가 성립되지 않으므로, 외부에서 이 객체에 직접적인 접근을 못하도록 은닉시킨다.
	 */
	private static Calc2 current;
	
	/*
	 * current객체를 private으로 지정하였기 때문에 객체를 메모리에서 간접적으로 할당하고 삭제하기 위한 메서드가 필요하다.
	 * - 객체가 할당되지 않은 경우에만 할당하도록 하여 중복할당을 방지한다.
	 */
	public static Calc2 getInstance() {
		if(current == null) {
			current = new Calc2();
		}
		return current;
	}
	
	// - 객체에 null을 대입하면 메모리에서 삭제된다.
	public static void freeInstance() {
		current = null;
	}
	
	/*
	 * new 연산자를 사용한 객체 할당 금지
	 * - 기본생성자를 private 형태로 정의하면 객체 생성자가 은닉처리되어 외부에서 new 연산자를 사용한 객체 할당이 금지된다.
	 */
	private Calc2(){
		super();
	}
	
	////////////////////////////////
	public int plus(int x, int y) {
		return x+y;
	}
	
	public int minus(int x, int y) {
		return x-y;
	}
	
	public int times(int x, int y) {
		return x*y;
	}
	
	public int divide(int x, int y) {
		return x/y;
	}
}