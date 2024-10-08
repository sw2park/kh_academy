package boxing;

public class Main02 {
	public static void main(String[] args) {
		AirForce af = new AirForce("공군");
		Navy nv = new Navy("해군");
		Army am = new Army("육군");
		
		// 각각의 객체는 자신들의 공유 기능을 사용할 수 있음
		af.bombing();
		nv.nucleus();
		am.tank();
		
		System.out.println("-------------------------------");
		
		/*
		 * 1. 각각의 af, nv, am 이라는 객체를
		 * temp1, temp2, temp3라는 이름의 상위 객체로
		 * 암묵적 형변환
		 */
		
		Unit temp1 = af;
		Unit temp2 = nv;
		Unit temp3 = am;
		
		/*
		 * 2. temp1, temp2, temp3 객체로 attack()이라는 메서드를 각각 호출
		 */
		temp1.attack();
		temp2.attack();
		temp3.attack();
		
		System.out.println("-------------------------------");
		
		// 상위 클래스 형태로 형변환이 되면,
		// 자신들의 독립 기능은 사용하지 못함
//		temp1.bombing();
//		temp2.nucleus();
//		temp3.tank();
		
		// 명시적 형변환
		// 다시 원래의 기능을 되돌리기 위해서는 
		// 하위 클래스 형태로 명시적 형변환이 필요함
		AirForce re1 = (AirForce)temp1;
		Navy re2 = (Navy)temp2;
		Army re3 = (Army)temp3;
		
		re1.bombing();
		re2.nucleus();
		re3.tank();
	}
}