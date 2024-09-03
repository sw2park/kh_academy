package math;

import study.java.helper.Util;

public class Main03 {
	public static void main(String[] args) {
		// 5자리의 인증번호 생성 (각 자리수마다 0~9사이의 랜덤한 정수 값)
		Util num1 = Util.getInstance();
		
		for(int i=0; i<5; i++) {
			System.out.print(num1.random(0, 9));
		}		
	}
}
