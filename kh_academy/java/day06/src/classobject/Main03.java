package classobject;

class HelloWorld{
	String message;
	void sayHello() { System.out.println(message); }
	void setEng() { message = "Hello Java"; }
	void setKor() { message = "안녕하세요. 자바"; }
}
public class Main03 {
	public static void main(String[] args) {
		HelloWorld hello = new HelloWorld(); 
		hello.setEng();
		hello.sayHello();
		hello.sayHello();
		
		hello.setKor();
		hello.sayHello();
	}

}








