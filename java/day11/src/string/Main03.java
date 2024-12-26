package string;

public class Main03 {
	public static void main(String[] args) {
		/*
		 * 주민번호에서 생년월일을 추출
		 * 800501 1234567 -> 1990년 05월 01일 남자 << 로 출력
		 * - 태어난 년도 판별 : 	1 or 2 -> 19~
		 * 					3 or 4 -> 20~
		 * - 성별 판단		:	1 or 3 -> 남자
		 * 					2 or 4 -> 여자  
		 */
		// 년도 1, 2 / 월 / 일 / 성별
		String soSecNum = "8005011234567";
		String frontYear;
		String backYear = soSecNum.substring(0,2);
		String month = soSecNum.substring(2,4);
		String date = soSecNum.substring(4,6);
		String frontSoSecNum = soSecNum.substring(0,6);
		String backSoSecNum = soSecNum.substring(6, 7);
		String gender;
		
		if(backSoSecNum.equals("1") || backSoSecNum.equals("3")) {			
			gender = "남자";
		} else {
			gender = "여자";
		}
		
		if(backSoSecNum.equals("1") || backSoSecNum.equals("2")) {
			frontYear = "19";
		} else {
			frontYear = "20";
		}
		System.out.println(frontYear + backYear + "년 " + month + "월 " + date + "일 " + gender );
		
		// 강사쌤이 한것
		String jumin = "8005011234567";
		
		// 주민번호를 년, 월, 일 단위로 각 두 글자씩 자르기
		String yy = jumin.substring(0, 2);
		String mm = jumin.substring(2, 4);
		String dd = jumin.substring(4, 6);
		
		// 뒷부분 첫 번째 글자는 성별 코드이므로 별도로 추출
		String gender_code = jumin.substring(6, 7);
		
		// 태어난 년도의 판별
		if(gender_code.equals("1") || gender_code.equals("2")) {
			yy = "19" + yy;
		} else {
			yy = "20" + yy;
		}
		
		// 기본 성별은 남자
		String tgender = "남자";
		
		// 뒷 부분 성별 코드가 2,4 인 경우 "여자"
		if(gender_code.equals("2") || gender_code.equals("4")) {
			tgender = "여자";
		}
		
		// 형식에 맞춘 내용 출력
		// String.format + System.out.prinln
		System.out.printf("%s년 %s월 %s일 %s", yy, mm, dd, tgender);
	}
}