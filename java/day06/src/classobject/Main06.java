package classobject;

class Member{
	String name;
	int age;
	
	String getName() {
		return this.name;
	}
	void setName(String name) {
		this.name = name;
	}
	int getAge() {
		return this.age;
	}
	void setAge(int age) {
		this.age = age;
	}
	void say() {
		System.out.println(this.getName());
		System.out.println(this.getAge());
	}
}

public class Main06 {

	public static void main(String[] args) {
		Member m = new Member();
		m.setName("자바학생");
		m.setAge(20);
		m.say();
	}

}










