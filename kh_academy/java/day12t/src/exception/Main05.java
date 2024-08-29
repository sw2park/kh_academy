package exception;

public class Main05 {

	public static void main(String[] args) {
		// 사용자가 입력값을 가정
		String[] src = {"5", "2", "1"};
		
		// src의 내용들을 숫자로 변환해서 저장할 배열
		int[] arr = new int[3];
		
		try {
			for(int i=0; i<src.length; i++) {
				arr[i] = Integer.parseInt(src[i]);
				System.out.println(arr[i]);
			}
		} catch (NumberFormatException e) {
			System.out.println("입력값에 오류가 있습니다.");
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("데이터가 너무 많습니다.");
			e.printStackTrace();
		} catch (Exception e) {
			// 이 블록은 모든 종류의 예외에 대처할 수 있다
			// 예외 종류를 의미하는 모든 클래스는
			// java.lang.Exception 클래스를 상속받는다.
			System.out.println("알 수 없는 예외가 발생했습니다.");
			e.printStackTrace();
		} finally {
			System.out.println("데이터 변환 종료");
		}
		
		System.out.println("---- 프로그램 종료 ----");
		
		
	}

}









