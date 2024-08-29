package Static;

public class Main01 {
	public static void main(String[] args) {
		Article.setCategory("자유게시판");
		
		Article a1 = new Article(1, "1번글", "2024-07-20");
		Article a2 = new Article(2, "2번글", "2024-07-21");
		Article	a3 = new Article(3, "3번글", "2024-07-22");
		
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		System.out.println(a3.toString());
		System.out.println("-------------------------------------------------------------------------");

		// static 변수의 값을 변경하면, 모든 객체가 영향을 받는다.
		Article.setCategory("공지사항");
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		System.out.println(a3.toString());
	}
}
