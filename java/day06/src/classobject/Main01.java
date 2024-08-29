package classobject;

class Student{
	// 멤버변수 선언 + 할당
	String name = "자바학생";
	int age = 19;
}

public class Main01 {

	public static void main(String[] args) {
		// 객체의 선언과 할당 분리
		Student std1;
		std1 = new Student();
		
		// 객체의 생성 일괄 지정
		Student std2 = new Student();
		
		System.out.println("std1 이름 : " + std1.name);
		System.out.println("std1 나이 : " + std1.age);
		
		System.out.println("std2 이름 : " + std2.name);
		System.out.println("std2 나이 : " + std2.age);
		
		// std1 객체의 name과 age 멤버변수를 임의의 값으로 변경
		// std1 name과 age, std2 name과 age 를 각각 출력
		System.out.println("---------------");
		std1.name = "김하나";
		std1.age = 30;
		
		System.out.println("std1 이름 : " + std1.name);
		System.out.println("std1 나이 : " + std1.age);
		
		System.out.println("std2 이름 : " + std2.name);
		System.out.println("std2 나이 : " + std2.age);
		
	}

}






















