package exception;

public class Main04 {
	
	public static void main(String[] args) {
		try {
			int[] arr = new int[3];
			for(int i=0; i<5; i++) {
				arr[i] = i;		// i가 3일때 에러 발생
				System.out.println(i);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("오류 발생");
			System.out.println("원인 : " + e.getMessage());
		}
		System.out.println("----- 프로그램을 종료합니다. -----");
	}

}









