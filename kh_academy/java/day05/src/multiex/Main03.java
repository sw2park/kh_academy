package multiex;

public class Main03 {

	public static void main(String[] args) {
		/*
		 * 1. 구구단 2단 출력
		 * [console]
		 *  2 * 1 = 2
		 *  2 * 2 = 4
		 *  ...
		 *  2 * 9 = 18
		 */
		int gugu = 2;
		for( int i = 1; i<=9; i++ ) {
			System.out.println(gugu + " * " + i + " = " + gugu*i);
		}
		System.out.println("-----------------------");
		
		/*
		 * 2. while문 으로만
		 * [console]
		 * 나무를 1번 찍었습니다
		 * 나무를 2번 찍었습니다
		 * 나무를 3번 찍었습니다
		 * ...
		 * 나무를 10번 찍었습니다
		 * 나무 넘어갑니다
		 */
		int treeHit = 0;
		while( treeHit < 10 ) {
			treeHit++;
			System.out.println("나무를 " + treeHit + "번 찍었습니다.");
			if( treeHit == 10 ) {
				System.out.println("나무 넘어갑니다.");
			}
		}
		
	}

}







