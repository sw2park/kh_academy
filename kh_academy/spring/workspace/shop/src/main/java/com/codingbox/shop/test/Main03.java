package com.codingbox.shop.test;

public class Main03 {
	public static void main(String[] args) {
		// 파라미터가 없음
		test();
		
		// 파라미터가 한개
		test("A");
		
		// 파라미터가 두개
		test("A", "B");
		
		// 배열로 전달
		test(new String[] {"A", "B", "C"});
		
		test(10);
		
		test(10, new String[] {"A", "B", "C"});

	}
	
	public static void test(String... param) {
		System.out.println("-------------------");
		String[] array = param; // 배열화 된다.
		
		for(String str : param) {
			System.out.println(str);
		}
	}
	
	// 다른 파라미터와 가변인자를 같이 사용하는 경우에는 가변인자를 제일 뒤에 위치 시켜야 한다.
	public static void test(int num, String... param) {
		System.out.println("---------------------");
		System.out.println("num : " + num);
		
		String[] array = param;		// 배열화 된다.
		
		for(String str : param) {
			System.out.println(str);
		}
	}
}
