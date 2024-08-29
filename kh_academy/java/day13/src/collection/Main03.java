package collection;

import java.util.ArrayList;
import java.util.List;

public class Main03 {

	public static void main(String[] args) {
		/*
		 * List를 사용하는 가장 일반적인 방법은,
		 * 사용자 정의 클래스에 대한 객체를 포함하도록
		 * 지정하는 것이다.
		 */
		
		// 객체를 담기위한 ArrayList
		List<People> plist = new ArrayList<People>();
		
		// plist에 10명의 데이터를 임의로 추가
		// 회원0, 01012345670
		// 회원1, 01012345671
		// ...
		// 회원9, 01012345679
		for( int i=0; i<10; i++ ) {
			People p 
			= new People("회원"+ i, "0101234567" + i);
			plist.add(p);
		}
		
		// 출력하기
		for(int i=0; i<plist.size(); i++) {
			// List에 저장된 데이터를 하나 꺼내면,
			// People클래스 형의 객체가
			People item = plist.get(i);
			System.out.println(item.toString());
		}
	}
	
}







