package operator;

public class Main03 {

	public static void main(String[] args) {
		int source = 100;
		
		source += 100;	// 200
		source -= 50;	// 150
		source *= 2;	// 300
		source /= 100;	// 3
		source %= 2;	// 1
		
		System.out.println(source);
	}
}
