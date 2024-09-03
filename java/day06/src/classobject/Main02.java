package classobject;

class Character{
	String name;
	String job;
	int age;
}

public class Main02 {

	public static void main(String[] args) {
		Character char1 = new Character();
		char1.name = "둘리";
		char1.job = "공룡";
		char1.age = 150;
		
		Character char2 = new Character();
		char2.name = "희동";
		char2.job = "애기";
		char2.age = 3;
		
		System.out.println("이름 : " + char1.name 
				+ ", 직업 : " + char1.job
				+ ", 나이 : " + char1.age);
		System.out.println("이름 : " + char2.name 
				+ ", 직업 : " + char2.job
				+ ", 나이 : " + char2.age);
	}
	

}
















