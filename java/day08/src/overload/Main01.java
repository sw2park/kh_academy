package overload;

public class Main01 {
	public static void main(String[] args) {
		Character c = new Character();
		
		System.out.println(c.toString());
		
		c.setProperty(30);
		System.out.println(c.toString());
		
		c.setProperty("개발자");
		System.out.println(c.toString());
		
		c.setProperty(20, "자영업");
		System.out.println(c.toString());
		
		c.setProperty("교수", 40);
		System.out.println(c.toString());
	}
}
