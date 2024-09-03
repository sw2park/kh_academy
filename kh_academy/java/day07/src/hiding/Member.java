package hiding;

public class Member {
	private String name;
	private int age;
	
	// 1.name, age를 파라미터로 받아서 멤버변수에 초기화하는
	// 생성자 만들것
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// 2.name과 age의 getter와 setter를 만들기
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
}








