package boxing;

public class Main01 {
	public static void main(String[] args) {
		// 부대지정
		Unit[] units = new Unit[5];
		
		units[0] = new AirForce("공군1호");
		units[1] = new AirForce("공군2호");
		units[2] = new Navy("해군1호");
		units[3] = new Army("육군1호");
		units[4] = new Army("육군2호");
		
		// 부대별 attack() 호출, for문
		// 부대 일괄 공격
		for(int i=0; i<units.length; i++) {
			units[i].attack();
			// 원래 클래스의 형태로 명시적 형변환 후
			// 독립적으로 추가한 기능을 사용하는 코드 작성
			if(units[i] instanceof Army) {
				Army temp = (Army)units[i];
				temp.tank();
			} else if (units[i] instanceof Navy) {
				Navy temp = (Navy)units[i];
				temp.nucleus();
			} else {
				AirForce temp = (AirForce)units[i];
				temp.bombing();
			}
		}
	}
}