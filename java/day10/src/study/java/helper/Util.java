package study.java.helper;

/*
 * 기본적인 공통 기능들을 묶어놓은 클래스
 */

public class Util {
	// ---------- 싱글톤 객체 생성 시작 -----------
	private static Util number;
	
	public static Util getInstance() {
		if(number == null) {
			number = new Util()	;
		}
		return number;
	}
	
	public static void freeInstance() {
		number = null;
	}
	
	private Util() {
		super();
	}
	
	// ---------- 싱글톤 객체 생성 끝 ------------
	
	
	
	/*
	 * 범위를 갖는 랜덤값을 생성하여 리턴하는 메서드
	 * @param min	- 범위 안에서의 최소값
	 * @param max	- 범위 안에서의 최대값
	 * @return 		- min~max 안에서의 랜덤값
	 */
	public static int random(int min, int max) {
		int num = (int)(Math.random() * (max - min + 1)) + min;

		return num;
	}
	
}
