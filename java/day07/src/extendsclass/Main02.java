package extendsclass;

public class Main02 {

	public static void main(String[] args) {
		FileArticle file = new FileArticle();
		file.setNum(1);
		file.setTitle("첫 번째 자료입니다.");
		file.setFileName("java.ppt");
		System.out.println(file.toString());
		
		System.out.println("---------------");
		
		QNAArticle qna = new QNAArticle();
		qna.setNum(1);
		qna.setTitle("첫 번째 질문입니다.");
		qna.setAnswer("첫 번째 답변입니다.");
		System.out.println(qna.toString());
		
	}

}








