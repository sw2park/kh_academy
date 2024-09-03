package classobject;

class Article{
	int seq;		// 글 번호
	String subject;	// 글 제목
	String writer;	// 작성자
	
	// 1. 생성자 생성, seq, subject, writer 멤버변수의 값에
	// 값을 할당하는 파라미터를 가진 생성자를 만들것
	Article(int seq, String subject, String writer) {
		this.seq = seq;
		this.subject = subject;
		this.writer = writer;
	}
	
	// 2. print(), void, seq, subejct, writer를 각각 출력
	void print() {
		System.out.println(this.seq);
		System.out.println(this.subject);
		System.out.println(this.writer);
	}
}
public class Main03 {
	public static void main(String[] args) {
		// 3. Article class로 객체1 생성
		Article article1 = new Article(1,"자바 주제1","자바학생");
		// 4. print() 호출
		article1.print();
		
		System.out.println("-------------");
		// 5. Article class로 객체2 생성
		Article article2 = new Article(2, "자바주제2", "홍길동");
		// 6. 객체2.print()
		article2.print();
	}

}







