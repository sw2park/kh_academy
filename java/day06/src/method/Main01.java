package method;

public class Main01 {

	public static void main(String[] args) {
		plus();
		plus();
		plus();
		plus();
		plus();
		minus();
		minus();
	}
	
	public static void plus() {
		int x = 100;
		int y = x + 1;
		System.out.println("y : " + y);
	}
	
	public static void minus() {
		int x = 100;
		int y = x -1;
		System.out.println("y : " + y);
	}

}









