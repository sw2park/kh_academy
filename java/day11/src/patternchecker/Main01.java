package patternchecker;

import java.util.regex.Pattern;

public class Main01 {
	public static void main(String[] args) {
		// 회원가입시에 입력한 내용을 가정한 변수값들
		String name = "김자바";
		String age = "19";
		String email = "user@java.com";
		String phone = "01012345678";
		
		// 한글 여부 검사
		boolean isKor = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
		// 숫자인지를 검사
		boolean isNum = Pattern.matches("^[0-9]*$", age);
		// 이메일 검사
//		boolean isEmail = Pattern.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$", email);
		// 아래건 @와 .까지 포함한 정규표현식
		boolean isEmail = Pattern.matches("^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$", email);
		// 휴대폰 번호 형식 검사
		boolean isPhone = Pattern.matches("^\\d{2,3}\\d{3,4}\\d{4}$", phone);
		
		if(!isKor) {
			System.out.println("이름은 한글로만 입력해 주세요.");
			// 실행도중 return을 만나면 즉시 중단
			return;
		}
		
		if(!isNum) {
			System.out.println("나이는 숫자로만 입력해 주세요.");
			return;
		}
		
		if(!isEmail) {
			System.out.println("이메일은 이메일 형식이 맞지 않습니다.");
			return;
		}
		
		if(!isPhone) {
			System.out.println("휴대폰 번호는 형식에 맞게 입력해 주세요.");
			return;
		}
		System.out.println("회원가입 절차를 진행합니다.");
	}
}
