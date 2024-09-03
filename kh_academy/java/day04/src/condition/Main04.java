package condition;

public class Main04 {
	public static void main(String[] args) {
		// 강사쌤이 작성한 것
		// 1~5번까지 if문 
	      /*
	       * 1. 만약 3000원 이상의 돈을 가지고 있으면
	       * "택시를 타고 가라"를 출력,
	       * 그렇지 않으면 "걸어가라"를 출력 
	       */
		
		int money = 5000;
		if (money >= 3000) {
			System.out.println("택시를 타고 가라.");
		} else {
			System.out.println("걸어가라.");
		}
		
		System.out.println("---------------------");
	      
	      /*
	       * 2. 만약 돈이 3000원 이상 있거나, 카드가 있다면
	       * "택시를 타고 가라"를 출력,
	       * 그렇지 않다면 "걸어가라"를 출력
	       */
		int money2 = 1000;
		boolean hasCard = true;
		if(money2 >= 3000 || hasCard) {
			System.out.println("택시를 타고 가라.");
		} else {
			System.out.println("걸어가라.");
		}
		System.out.println("---------------------");
	      
	      /*
	       * 3. int a = 10;
	       * 어떤 특정 정수값 a가 짝수이면 "짝수", 홀수이면 "홀수"를 출력
	       */
		
		int a = 4;
		if(a % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		System.out.println("---------------------");
	      
	      /*
	       * 4. 서로다른 특정 정수값 a1 = 10, b1 = 20, c1 = 9이 있다.
	       * 이 중에서 최대값을 구하여라 
	       */
		
		int a1 = 10, b1= 20, c1 = 9;
		int max = 0;
		if(a1>b1 && a1>c1) {
			max = a1;
		} else {
			if (b1 > c1) {
				max = b1;
			} else {
				max = c1;
			}
		}
		System.out.println(max);
		System.out.println("---------------------");
	      
	      /*
	       * 5. 국어, 영어 수학 점수의 평균이 95점 이상이면 "장학생"출력 하여라.
	       */
		int kor = 95, eng = 90, mat = 100;
		int avg = (kor + eng + mat) / 3;
		System.out.println(avg);
		if(avg >= 95) {
			System.out.println("장학생");
		}
		System.out.println("---------------------");
	      
	      // 6번은 switch-case문
	      /*
	       * 6. 숫자가 3이면 "안녕"이 세줄,
	       * 2이면 "안녕"이 두줄, 1이면 "안녕"이 한줄, 
	       * 그 외에는 "잘가"가 출력되도록 하시오.
	       */
		int num = 3;
		switch(num) {
		case 3:
			System.out.println("안녕");
		case 2:
			System.out.println("안녕");
		case 1:
			System.out.println("안녕");
			break;
			default:
			System.out.println("잘가");
		}
		System.out.println("---------------------");
	      
	      // 7번. 삼항연산자
	      /*
	       * 7. 12시보다 작으면 "오전", 크면 "오후" 출력
	       */
		int hour = 16;
		String ampm = hour < 12 ? "오전" : "오후";
		System.out.println(ampm);
	}
}