package overload;

public class Member {
	private String job;
	private int age;
	
	// 기본 생성자
	public Member() {}
	
	public Member(int age) {
		this.age = age;
	}
	
	public Member(String job) {
		this.job = job;
	}
	
	public Member(String job, int age) {
		this.job = job;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [job=" + job + ", age=" + age + "]";
	}
}