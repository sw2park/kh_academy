package classobject;

class User{
	String name;
	int age;
	
	User(String name, int age){
		// 생성자 파라미터의 값을 멤버변수에 할당
		this.name = name;
		this.age = age;
	}
}
public class Main02 {

	public static void main(String[] args) {
		// 생성자에 파라미터가 정의된 경우 객체 생성 구문에서
		// 해당 파라미터를 전달해야 한다.
		// 객체를 생성하면서 설정한 파라미터는 생성자를 통해
		// 멤버변수에 저장된다.
		User user = new User("자바학생", 25);
		
	}

}







