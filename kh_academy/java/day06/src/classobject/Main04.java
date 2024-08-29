package classobject;

class Calc{
	int plus(int x, int y) {
		return x + y;
	}
}

public class Main04 {

	public static void main(String[] args) {
		Calc calc1 = new Calc();
		int result = calc1.plus(100, 50);
		System.out.println("100+50=" + result);
		
		//Calc calc2 = new Calc();
		//System.out.println(calc2.plus(100, 200));
		System.out.println(calc1.plus(100, 200));
	}

}












