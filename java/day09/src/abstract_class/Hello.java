package abstract_class;

public abstract class Hello {
	private String msg;
	
	// 파라미터가 있는 생성자
	public Hello(String msg) {
		super();
		this.msg = msg;
	}

	// getter, setter 정의 - 일반 메서드
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	// 선언만 되고, 구현부를 위한 블록지 존재하지 않는다.
	// 추상 메서드
	public abstract void sayHello();
}