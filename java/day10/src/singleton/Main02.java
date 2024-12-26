package singleton;

public class Main02 {
	public static void main(String[] args) {
		Calc c2 = new Calc();
		int b = c2.minus(200, 100);
		System.out.println(b);
	}
}
