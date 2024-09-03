package math;

import study.java.helper.Util;

public class Main01 {
	public static void main(String[] args) {
		// 5자리의 인증번호 생성 (각 자리수마다 0~9사이의 랜덤한 정수 값)
		// 강사쌤이 하신 것
		String authNum = "";
		
		for(int i=0; i<5; i++) {
			authNum += Util.getInstance().random(0, 9);
		}
		
		System.out.println("인증번호 = " + authNum);
	}
}
