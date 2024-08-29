package kr.co.khacademy.myapp.main;

// 이러한 번거로움을 피하고자 클래스 정의 전에 import 구문을 사용하여 특정 클래스의 이름이 어떤 패키지에 소속되어 있는지를 명시할 수 있다.
import kr.co.khacademy.myapp.board.Article;

public class Main01 {
	public static void main(String[] args) {
		// 1.다른 패키지의 클래스를 사용하고자 할 경우, 패키지 이름을 포함한 FullName으로 사용해야 한다.
//		kr.co.khacademy.myapp.board.Article article = new kr.co.khacademy.myapp.board.Article(1, "게시판", "24-07-23");
		
		Article a1 = new Article(1, "게시판", "2024-07-23");
	}
}