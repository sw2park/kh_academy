package condition;

public class Main04 {
	public static void main(String[] args) {
		int point = 90;
		
		/*
		 * 만약 point가 90점 초과이고, point가 100점 이하이면 -> "A" 출력
		 * 만약 point가 80점 초과이고, point가 90점 이하이면 -> "B" 출력
		 * 만약 point가 70점 초과이고, point가 80점 이하이면 -> "C" 출력
		 * 나머지 -> "F"출력
		 */
		
		if(point > 90 && point <= 100) {
			System.out.println("A");
		}else if(point > 80 && point <= 90) {
			System.out.println("B");
		}else if(point > 70 && point <= 80) {
			System.out.println("C");
		}else{
			System.out.println("F");
		}
	}
}