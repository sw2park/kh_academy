package condition;

public class Main03 {
	public static void main(String[] args) {
		// 1~5번 if문으로 작성, 시간되면 swich~case문으로 작성
		/*
		 * 1. 만약 3000원 이상의 돈을 가지고 있으면
		 * "택시를 타고 가라."를 출력,
		 * 그렇지 않으면 "걸어가라."를 출력
		 */
		
//		int money1 = 2999;
//		String advice1 = (money1 >= 3000) ? "택시를 타고 가라." : "걸어가라.";
//		System.out.println(advice1);
		
		int money1 = 3000;
		if (money1 >= 3000)
			System.out.println("택시를 타고 가라.");
		else
			System.out.println("걸어가라.");
		
		/*
		 * 2. 만약 돈이 3000원 이상 있거나, 카드가 있다면
		 * "택시를 타고 가라."를 출력,
		 * 그렇지 않다면 "걸어가라"를 출력 
		 */
		
//		int money2 = 2999;
//		boolean isCard = false;
//		String advice2 = (money2 >= 3000 || isCard == true) ? "택시를 타고 가라." : "걸어가라.";
//		System.out.println(advice2);
		
		int money2 = 3000;
		boolean isCard = true;
		if(money2 >= 3000 || isCard == true)
			System.out.println("택시를 타고 가라.");
		else
			System.out.println("걸어가라.");
		
		/*
		 * 3. int a = 10(변동가능);
		 * 어떤 특정 정수값 a가 짝수이면 "짝수", 홀수이면 "홀수"를 출력 
		 */
//		int a = 9;
//		String oddNumber = (a%2 == 0) ? "짝수" : "홀수";
//		System.out.println(oddNumber);
		
		int a = 8;
		if(a%2 == 0)
			System.out.println("짝수");
		else
			System.out.println("홀수");
		
		/*
		 * 4. 서로 다른 특정 정수값 a1 = 10, b1 = 20, c1 = 9이 있다.
		 *  이 중에서 최대 값을 구하여라.
		 */
		
		int a1 = 6;
		int b1 = 5;
		int c1 = 4;
		
		int max = 0;
		
		if(a1 > b1 && a1 > c1)
			max = a1;
		else if(b1 > a1 && b1 > c1)
			max = b1;
		else if(c1 > a1 && c1 > b1)
			max = c1;
		
		System.out.println(max);
		
		
		/*
		 * 5. 국어, 영어, 수학 점수의 평균이 95점 이상이면 "장학생"출력하여라.
		 */
		int kor = 95;
		int eng = 100;
		int math = 95;
		
		if ((kor+eng+math)/3 >= 95)
			System.out.println("장학생");
		
		// 6번은 switch-case문 사용
		/*
		 * 6. 숫자가 3이면 "안녕"이 세줄,
		 * 2이면 "안녕"이 두줄, 1이면 "안녕"이 한줄,
		 * 그 외에는 "잘가"가 출력되도록 하시오.
		 */
		
		int num1 = 0;
		
		switch(num1) {
		case 3: 
			System.out.println("안녕");
			System.out.println("안녕");
			System.out.println("안녕");
			break;
		case 2 :
			System.out.println("안녕");
			System.out.println("안녕");
			break;
		case 1: 
			System.out.println("안녕");
			break;
		default :
			System.out.println("잘가");
			break;
		}
		
		/*
		 * 7. 삼항연산자
		 * 7. 12시보다 작으면 "오전", 크면 "오후"출력
		 */
		int time = 11;
		String afternoon = (time < 12) ? "오전" : "오후";
		System.out.println(afternoon);
	}
}