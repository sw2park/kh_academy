package collection;

import java.util.HashMap;
import java.util.Map;

public class Main01 {

	public static void main(String[] args) {
		// 데이터를 저장할 배열 생성
		// 제너릭 -> <값의 이름, 값의 종류>
		Map<String, Integer> hm 
			= new HashMap<String, Integer>();
		
		// 데이터 추가는 put 메서드 사용
		// -> 중복을 허용하지 않는다.
		hm.put("kor", 95);
		hm.put("mat", 100);
		hm.put("eng", 85);
		
		// 지정된 갯수 얻기
		System.out.println("HashMap size : " + hm.size());
		
		// 객체를 넣는것이므로 Null 사용 가능
		hm.put("eng", null);	
		System.out.println("HashMap size : " + hm.size());
		
		// 데이터 꺼내기
		System.out.println(hm.get("kor"));
		System.out.println(hm.get("mat"));
		System.out.println(hm.get("eng"));
	}

}








