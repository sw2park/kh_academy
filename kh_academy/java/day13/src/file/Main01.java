package file;

import java.io.File;

public class Main01 {

	public static void main(String[] args) {
		File file = new File("src/file/Main01.java");
		
		// 전달된 경로가 파일인지를 검사
		// -> 존재하지 않은 파일로 검사할 경우 무조건 false
		boolean is_file = file.isFile();
		System.out.println("is_file : " + is_file);
		
		// 전달된 경로가 디렉토리인지 검사
		// -> 존재하지 않는 디렉토리로 검사할 경우 무조건 false
		boolean is_dir = file.isDirectory();
		System.out.println("is_dir : " + is_dir);
		
		// 전달된 경로가 숨긴형태인지 검사
		// -> 존재하지 않는 파일로 검사할 경우 무조건 false
		boolean is_hidden = file.isHidden();
		System.out.println("is_hidden : " + is_hidden);
		
		// 절대경로 값을 추출
		String abs = file.getAbsolutePath();
		System.out.println("절대경로 : " + abs);
		
		// 생성자에 전달된 파일이나 디렉토리가 물리적으로
		// 존재하는지를 검사
		boolean is_exist = file.exists();
		System.out.println("존재여부 : " + is_exist);
		System.out.println("-----------------------");
		
		// 디렉토리 정보 객체 생성
		File file2 = new File("a/b/c/target");
		System.out.println("isFile : " + file2.isFile());
		System.out.println("isDirectory : " + file2.isDirectory());
		System.out.println("isHidden : " + file2.isHidden());
		System.out.println("절대경로 : " + file2.getAbsolutePath());
		System.out.println("존재여부 : " + file2.exists());
		
		// 경로에 따른 디렉토리 생성
		file2.mkdirs();
		System.out.println("---------------");
		
		// 마지막 "/" 이후 단어를 리턴
		System.out.println(file.getName());
		System.out.println(file2.getName());
		
		// 처음부터 마지막 "/" 직전까지 리턴
		System.out.println(file.getParent());
		System.out.println(file2.getParent());
	}

}






