package condition;

public class Main02 {

	public static void main(String[] args) {
		int point = 70;
		
		/*
		 * 1. point가 70 초과이고, 80점 이하이면
		 * "C학점 입니다." 출력
		 */
		
		if(point>70 && point <=80)
			System.out.println("C학점 입니다.");
		
		/*
		 * 2. point가 70점 이하이고, 80점 초과이면
		 * "범위를 벗어났습니다." 출력
		 */
		
		if(point<=70 || point > 80)
			System.out.println("범위를 벗어났습니다.");

	}

}
