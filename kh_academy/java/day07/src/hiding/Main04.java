package hiding;

public class Main04 {

	public static void main(String[] args) {
		// 3. Article class로 객체 생성후
		Article article 
		= new Article(1, "테스트 게시물", "자바는 객체지향 언어이다."
				, "홍길동", 0, "2024-07-18");
		
		// 4. 각각의 데이터들을 getter 메서드로 출력
		System.out.println(article.getSeq());
		System.out.println(article.getSubject());
		System.out.println(article.getContent());
		System.out.println(article.getWriter());
		System.out.println(article.getHit());
		System.out.println(article.getRegDate());
	}

}









