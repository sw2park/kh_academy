package abstract_class;

public class Main01 {
	public static void main(String[] args) {
		AirForce af = new AirForce("공군");
		Navy nv = new Navy("해군");
		Army am = new Army("육군");
		
		/*
		 * 다형성이란, 객체의 이름이 서로 다르더라고 객체의 메서드를 호출할 때 고민하지 않기 위한 기법이다.
		 * 추상화는 다형성을 강제하는 것으로 객체를 사용하는 개발자의 편의를 위한 클래스 작성 규칙이다.	
		 */
		
		af.attack();
		af.move();
		
		nv.attack();
		nv.move();
		
		am.attack();
		am.move();
	}
}