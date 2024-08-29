package operator;

public class Main04 {
	public static void main(String[] args) {
		int plus_num = 1;
		plus_num = plus_num + 1;	// 2
		plus_num += 1;	// 3
		plus_num++;	// 4
		++plus_num;	// 5
		
		System.out.println(plus_num);
		
		int minus_num = 5;	
		minus_num = minus_num - 1;	// 4
		minus_num -= 1;	// 3
		minus_num--;	// 2
		--minus_num;	// 1 
		
		System.out.println(minus_num);
	
	}
}
