package string;

public class Main02 {
	public static void main(String[] args) {
		// 이메일 주소에서 아이디와 도메인을 구별
		// Split 사용 금지
		// student@java.com	->	변수로 선언
		// 아이디 : student
		// 도메인 : java.com 
		// 각각 출력
		
		String mailAdress = "student@java.com";
		int mailLastPos = mailAdress.lastIndexOf("@");
		String id = mailAdress.substring(0, mailLastPos);
		String domain = mailAdress.substring(mailLastPos+1);;
		
		System.out.println("id : " + id);
		System.out.println("domain : " + domain);
		
		// 강사쌤이 한 것
		String email = "student@java.com";
		
		// "@"가 나타나는 위치 얻기
		int s = email.indexOf("@");
		
		// 처음부터 "@"가 나타나는 위치까지 자르기 -> 아이디
		String email_id = email.substring(0, s);
		
		// "@"가 나타나는 위치 다음부터 끝까지 자르기 -> 도메인
		String email_domain = email.substring(s+1);
		
		System.out.println(email_id);
		System.out.println(email_domain);
	}
}