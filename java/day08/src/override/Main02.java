package override;

class Parent {
	public Parent (String msg) { System.out.println(msg);	}
}

class Child extends Parent{
	/*
	 * 부모 생성자를 강제 호출
	 *  - 생성자가 정의된 클래스를 상속받은 경우에는 자식 클래스의 생성자를 통해서 부모 생성자를 강제로 호출해야한다.
	 *  - 부모의 생성자를 호출하는 방법은 super 키워드를 메서드 이름으로 사용하는 것이다.
	 *  - 부모와 동일한 파라미터를 받도록 생성자를 정의하고, 전달받은 파라미터를 부모에게 재 전달한다.
	 */
	public Child (String msg){
		super(msg);
	}
}

public class Main02 {
	public static void main(String[] args) {
	}
}