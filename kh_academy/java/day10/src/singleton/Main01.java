package singleton;

public class Main01 {
	public static void main(String[] args) {
		Calc c1 = new Calc();
		int a = c1.plus(100, 200);
		System.out.println(a);
		System.out.println(c1);
		
		Calc c2 = new Calc();
		int b = c2.minus(200, 100);
//		int b = c1.minus(200, 100);
		System.out.println(b);
		System.out.println(c2);
	}
}
