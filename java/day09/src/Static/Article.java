package Static;

public class Article {
	// 전체 게시물의 수를 표현하기 위한 데이터
	private static int count = 0;
	private static String category;
	// 모든 게시물은 하나의 카테고리 안에 존재한다고 가정한다.
	// 게시물의 분류를 구별하기 위한 데이터
	private int num;		// 글번호
	private String title;	// 제목
	private String regDate;	// 작성일시
	
	public Article(int num, String title, String regDate) {
		super();
		this.num = num;
		this.title = title;
		this.regDate = regDate;
		/*
		 * 이 클래스에 대한 객체 생성 -> 게시물 신규 등록
		 * 게시물이 새로 등록될 때마다, 전체 글 수를 의미하는
		 * count 변수가 1씩 증가한다.
		 * 전체 게시물 수는 모든 객체가 공유하는 값이므로,
		 * static 으로 선언이 되어야한다.
		 */
		count++;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Article.count = count;
	}

	public static String getCategory() {
		return category;
	}

	public static void setCategory(String category) {
		Article.category = category;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "글 분류=" + category 
				+ ", 전체 글 수=" + count 
				+ ", Article [num=" + num 
				+ ", title=" + title 
				+ ", regDate=" + regDate + "]";
	}
	
}