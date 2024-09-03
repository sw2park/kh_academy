package classobject;

class Calculator{
	// plus(int, int), return x + y;
	int plus(int x, int y) {return x + y;}
	
	// minus(int, int), return x - y;
	int minus(int x, int y) {return x - y;}
	
	// times(int, int), return x * y;
	int times(int x, int y) {return x * y;}
	
	// divide(int, int), return x / y;
	int divide(int x, int y) {
		int result = 0;
		if( y != 0 ) {
			result = x / y;
		} 
		return result;
	}
}

public class Main05 {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		int p = c.plus(100, 50);
		System.out.println("100+50=" + p);
		System.out.println("100-50=" + c.minus(100, 50));
		System.out.println("100*50=" + c.times(100, 50));
		System.out.println("100/50=" + c.divide(100, 50));
	}

}






