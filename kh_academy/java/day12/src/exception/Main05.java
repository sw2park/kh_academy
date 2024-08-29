package exception;

public class Main05 {
	public static void main(String[] args) {
		// 사용자가 입력값을 가정
		String[] src = {"가", "2", "aaa", "ccc"};
		
		// src의 내용들을 숫자로 변환해서 저장할 배열
		int[] arr = new int[3];
		// for문 try 구문 처리
		try {
			for(int i=0; i<src.length; i++) {
				arr[i] = Integer.parseInt(src[i]);
				System.out.println(arr[i]);
			}
		} catch (NumberFormatException e) {
			// catch 	: NumberFormatException
			e.printStackTrace();
			System.out.println("NumberFormatException 발생");
			System.out.println("입력값에 오류가 있습니다.");
		} catch (ArrayIndexOutOfBoundsException e) {
			// catch 	: ArrayIndexOutOfBoundsException
			e.printStackTrace();
			System.out.println("ArrayIndexOutOfBoundsException 발생");
			System.out.println("데이터가 너무 많습니다.");
		} catch (Exception e) {
			// catch 	: Exception
			// 이 블록은 모든 종류의 예외에 대처할 수 있다.
			// 예외 종류를 의미하는 모든 클래스는 
			// java.lang.Exception 클래스를 상속받는다.
			e.printStackTrace();
			System.out.println("Exception 발생");
			System.out.println("알 수 없는 예외가 발생했습니다.");
		} finally {
			// finally 	: "데이터 변환 종료"
			System.out.println("데이터 변환 종료");
		}
		System.out.println("------프로그램 종료------");
	}
}