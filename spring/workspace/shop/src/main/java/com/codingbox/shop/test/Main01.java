package com.codingbox.shop.test;

public class Main01 {
	/*
	 * 사용할 때는 클래스의 인스턴스를 생성하는 것과 비슷하지만, new가 없는 형태이다.
	 */
	public static void main(String[] args) {
		Week today = Week.MONDAY;
		System.out.println(today);
		
		Week.MONDAY.dayInfo();
		Week.FRIDAY.dayInfo();
	}
}