package condition;

public class Main01 {
	public static void main(String[] args) {
		// 조건식
		int result;
		
		if(5<4) {
			result = 50;
		} else {
			result = 40;
		}
		
		// 삼항 연산자
		// 변수 = 조건식 ? 반환값1 : 반환값2;
		int result2 = (5<4) ? 50 : 40;
		
		System.out.println(result);
		System.out.println(result2);
	}
}
