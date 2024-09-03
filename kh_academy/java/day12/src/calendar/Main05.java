package calendar;

import java.util.Calendar;

public class Main05 {
	public static void main(String[] args) {
		// 어떤 처리에 대한 시작 시간을 얻는다.
		Calendar cal = Calendar.getInstance();
		// 현재 시각에 대한 TimeStamp를 밀리세컨드 단위로 얻기
		long ms1 = cal.getTimeInMillis();
		System.out.println("파일 복사 시작 >> " + ms1);
		
		// 파일 복사 프로그램을 주어진 시간동안 처리
		// ...
		
		// 처리에 대한 종료 시각 얻기. 타임스탬프를 얻는 또 다른 방법
		long ms2 = System.currentTimeMillis();
		System.out.println("파일 복사 끝 >> " + ms2);
		
		// 두 시간의 차이 얻기
		long x = ms2 - ms1;
		System.out.println(x);
	}
}