package multiex;

public class Main01 {

	public static void main(String[] args) {
//		System.out.println("안녕");
//		System.out.println("하세요");
//		System.out.print("안녕");
//		System.out.print("하세요");
//		System.out.println("");
//		System.out.print("안녕히");
//		System.out.print("가세요");
		
		/*
		 * System.out.print("★")
		 * System.out.println("★")
		 * 1번
		 	★★★★★★★★
			★★★★★★★★
			★★★★★★★★
			★★★★★★★★
			★★★★★★★★
			★★★★★★★★
			★★★★★★★★
			★★★★★★★★
		 */
		for(int i=0; i<=7; i++) { 		// 행
			for(int j=0; j<=7; j++) {	// 열
				System.out.print("★");
			}
			System.out.println("");
		}
		
		/*
		 * 2번.
		 	★★★★★★★★
			★★★★★★★
			★★★★★★
			★★★★★
			★★★★
			★★★
			★★
			★
		 */
		System.out.println("------------------");
		for( int i=0; i<=7; i++ ) {
			for( int j=i; j<=7; j++ ) {
				System.out.print("★");
			}
			System.out.println("");
		}
		
		
		/*
		 * 3번
 			★
			★★
			★★★
			★★★★
			★★★★★
			★★★★★★
			★★★★★★★
			★★★★★★★★
		 */
		System.out.println("---------------");
		for(int i=7; i>=0; i--) {
			for(int j=i; j<=7; j++) {
				System.out.print("★");
			}
			System.out.println("");
		}
		
	}

}









