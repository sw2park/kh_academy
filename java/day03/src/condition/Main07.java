package condition;

public class Main07 {

	public static void main(String[] args) {
		char grade = 'A';
		
		/*
		 * switch-case 문을 사용해서 grade가 A, B, C일때는 "Pass" 출력
		 * 그렇지 않다면 "Not-Pass"를 출력하라
		 */
		
		switch(grade) {
		case 'A':
		case 'B':
		case 'C':
			System.out.println("Pass");
			break;
		default:
			System.out.println("Not-Pass");
			break;
		}
	}

}
