package condition;


public class Main01 {
	public static void main(String[] args) {
		int myAge = 19;
		
		if(myAge == 19) {
			System.out.println("19살 입니다.");
		}
		
		// 만약, myAge가 20살이 아니라면,
		// "20살이 아닙니다"를 출력하시오.
		
		if(myAge != 20) 
			System.out.println("20살이 아닙니다.");
		
		// 만약, myAge가 20살 이상이면 
		// "넷플릭스 성인 컨텐츠를 감상할 수 있습니다."를 출력
		
		if(myAge >= 20)
			System.out.println("넷플릭스 성인 컨텐츠를 감상할 수 있습니다.");
		
		// 만약, myAge가 19살 이하면
		// "넷플릭스 성인 컨텐츠를 감상할 수 없습니다."를 출력
		if(myAge <= 19)
			System.out.println("넷플릭스 성인 컨텐츠를 감상할 수 없습니다.");	
	}
}
