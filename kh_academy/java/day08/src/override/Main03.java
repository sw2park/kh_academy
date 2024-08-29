package override;

public class Main03 {
	public static void main(String[] args) {
		Army am = new Army("육군");
		am.attack();
		am.tank();
		
		/*
		 * Navy : nucleus(), 핵미사일
		 * AirForce : bombing(), 폭격
		 */
		
		Navy na = new Navy("해군");
		na.attack();
		na.nucleus();
		
		AirForce ai = new AirForce("공군");
		ai.attack();
		ai.bombing();
	}
}