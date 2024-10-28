package com.codingbox.shop.test;

/*
 * 열거 상수는 상수 각각을 내부적으로 public static final 필드이며, 객체로 제공되도록 한다.
 * static이 붙어있기 때문에 각각의 상수는 클래스 변수로 클래스로더가 로드 시점에 JVM에서 고정 메모리 영역에 올려 놓는다.
 */
public enum Week {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	
	// enum은 일반 메서드를 가질 수 있다. 
	public void dayInfo() {
		System.out.println("dayInfo enum");
	}
}