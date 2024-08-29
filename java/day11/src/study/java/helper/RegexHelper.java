package study.java.helper;

import java.util.regex.Pattern;

public class RegexHelper {
	// ---------- 싱글톤 객체 생성 시작 -----------
	private static RegexHelper current;
	
	public static RegexHelper getInstance() {
		if(current == null) {
			current = new RegexHelper();
		}
		return current;
	}
	
	public static void freeInstance() {
		current = null;
	}
	
	private RegexHelper() {
		super();
	}
	// ---------- 싱글톤 객체 생성 끝 ------------
	
	/*
	 * 주어진 문자열이 공백이거나 null인지를 검사
	 * @param  str 		- 검사할 문자열
	 * @return boolean	- 공백, null이 아닐 경우 true
	 */
	// 강사쌤이 진행한것
	public boolean isValue(String str) {
		boolean result = false;
		if(str != null) {
			result = !str.trim().equals("");
		}
		
		return result;
	}
	// validation 처리를 위한 메서드 정의
	/*
	 * 한글로만 구성되어있는지 형식 검사
	 * @param	str		- 검사할 문자열
	 * @return 	boolean	- 형식에 맞을경우 true, 그렇지 않을경우 false
	 */
	public boolean isKort(String str) {
		boolean result = false;
		if(isValue(str)) {
			result = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", str);
		}
		return result;
	}
	// 숫자인지를 검사
	// @param : str - 검사할 문자열
	// @return : boolean - 형식이 맞을 경우 true, 그렇지 않을 경우 false
	public boolean isNumt(String str) {
		boolean result = false;
		if(isValue(str)) {
			result = Pattern.matches("^[0-9]*$", str);
		}
		return result;
	}
	
	// "-"없이 핸드폰 번호인지를 검사
	// @param : str - 검사할 문자열
	// @return : boolean - 형식이 맞을 경우 true, 그렇지 않을 경우 false
	public boolean isPhonet(String str) {
		boolean result = false;
		if(isValue(str)) {
			result = Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", str);
		}
		return result;
	}
	
	// 이메일 형식인지를 검사
	// @param : str - 검사할 문자열
	// @return : boolean - 형식이 맞을 경우 true, 그렇지 않을 경우 false
	public boolean isEmailt(String str) {
		boolean result = false;
		if(isValue(str)) {
			result = Pattern.matches("^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$", str);
		}
		return result;
	}
	
	// 아래는 내가 직접 작성한 것들
	public boolean isNull(String str) {
		boolean result = false;
		boolean isNull = Pattern.matches("^[\\s]*$", str);
		
		if(!isNull) {
			result = false;
		} else {
			result = true;
		}
		
		return result;
	}
	
	
	// 한글로만 구성되어있는지 정규표현식을 통해서 형식 검사 
	// 만약, 한글로만 이루어져 있다면 result = true;
	// 그렇지 않으면 result = false;
	// validation 처리를 위한 메서드 정의
	public boolean isKor(String str) {
		System.out.println(isNull(str));
		boolean result = false;
		boolean isKor = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", str);
		
		
		
		if (!isKor) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}
	// 숫자인지를 검사
	// @param : str - 검사할 문자열
	// @return : boolean - 형식이 맞을 경우 true, 그렇지 않을 경우 false
	public boolean isNum(String str) {
		boolean result = false;
		boolean isNumb = Pattern.matches("^[0-9]*$", str);
		
		if (!isNumb) {
			result = false;
		} else {
			result = true;
		}
		
		return result;
	}
	// "-"없이 핸드폰 번호인지를 검사
	// @param : str - 검사할 문자열
	// @return : boolean - 형식이 맞을 경우 true, 그렇지 않을 경우 false
	public boolean isPhone(String str) {
		boolean result = false;
		boolean isStr = Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", str);
		
		if(!isStr) {
			result = false;
		} else {
			result = true;
		}
		
		return result;
	}
	
	// 이메일 형식인지를 검사
	// @param : str - 검사할 문자열
	// @return : boolean - 형식이 맞을 경우 true, 그렇지 않을 경우 false
	public boolean isEmail(String str) {
		boolean result = false;
		boolean isStr = Pattern.matches("^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$", str);
		
		if(!isStr) {
			result = false;
		} else {
			result = true;
		}
		
		return result;
	}
}
