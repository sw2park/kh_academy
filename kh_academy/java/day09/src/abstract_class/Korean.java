package abstract_class;

// 추상 클래스를 상속받는 과정은 일반 클래스의 상속과 동일하게 'extends' 키워드를 사용한다.
public class Korean extends Hello{

	// 부모 생성자를 호출
	public Korean(String msg) {
		super(msg);
	}

	/*
	 * 부모 생성자의 호출을 처리하더라도 에러가 사라지지 않는 이유는, 
	 * 부모 클래스가 정의하고 있는 추상 메서드를 Override하지 않았기 때문이다.
	 * 즉, 추상 메서드의 재정의를 요구하기 위하여 에러가 표시된다.
	 */
	@Override
	public void sayHello() {
		System.out.println("안녕하세요.");
	}
}