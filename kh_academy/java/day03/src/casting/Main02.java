package casting;

public class Main02 {
	public static void main(String[] args) {
		long l = 100L;
		int i = (int)l;
		short s = (short)i;
		
		System.out.println("l : " + l);
		System.out.println("i : " + i);
		System.out.println("s : " + s);
		System.out.println("----------------");
		
		double pi1 = 3.14D;
		
		// 큰 범위의 변수를 작은 범위의 변수에 대임하는 것은 에러!
		// int pi2 = pi1;
		
		// 명시적 형변환이 필요
		int pi2 = (int)pi1;
		
		System.out.println("pi1 : " + pi1);
		System.out.println("pi2 : " + pi2);
	}
}
