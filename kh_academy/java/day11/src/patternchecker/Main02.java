package patternchecker;

import study.java.helper.RegexHelper;

public class Main02 {
	public static void main(String[] args) {
		// validation 처리를 RegexHelper의 메서드들을 사용해서 처리
		String name = "김자바";
		String age = "19";
		String email = "user@java.com";
		String phone = "01012345678";
	
		if(!RegexHelper.getInstance().isKort(name)) {
			System.out.println("이름은 한글로 입력해주세요.");
			return;
		}
		
		if(!RegexHelper.getInstance().isNumt(age)) {
			System.out.println("나이는 숫자로만 입력해 주세요.");
			return;
		}
		
		if(!RegexHelper.getInstance().isPhonet(phone)) {
			System.out.println("휴대폰 번호는 형식에 맞게 입력해 주세요.");
			return;
		}
		
		if(!RegexHelper.getInstance().isEmailt(email)) {
			System.out.println("이메일은 이메일 형식이 맞지 않습니다.");
			return;
		}
		
		System.out.println("회원가입 절차를 진행합니다.");
		// 아래는 내가 직접 작성한것들
//		RegexHelper dsname = RegexHelper.getInstance();
//		
//		System.out.println(dsname.isKor(name));
//		System.out.println(dsname.isNum(age));
//		System.out.println(dsname.isEmail(email));
//		System.out.println(dsname.isPhone(phone));
	}
}
