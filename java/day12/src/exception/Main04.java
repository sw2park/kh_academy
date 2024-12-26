package exception;

public class Main04 {
	// ArrayIndexOutofBoudsException
	// try ~ catch
	public static void main(String[] args) {
		int[] arr = new int[3];
		try {
			for(int i=0; i<5; i++) {
				arr[i] = i;		// i가 3일때 에러 발생, arr[3]에 값 넣을때 에러 발생
				System.out.println(arr[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("오류 발생");
			System.out.println("원인 : " + e.getMessage());
		}
		System.out.println("-----------프로그램을 종료합니다.--------------");
	}
}