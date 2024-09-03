package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class Main02 {

	public static void main(String[] args) {
		// 저장할 파일의 경로
		final String PATH = "./text.txt";
		
		// 파일에 저장할 내용
		String write_string = "가나다라마바사abcdefg";
		
		// 특정 인코딩 방식 적용
		/*
		 * getBytes() 메서드는 존재하지 않는 인코딩 형식에 대한
		 * 지정을 방지하기 위해여 예외처리를 강제적으로 요구한다.
		 */
		// 변수의 유효성 범위가 서로 달라서 buffer를 인식하지
		// 못하는 문제가 발
		byte[] buffer = null;
		try {
			buffer = write_string.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 파일 저장 절차 시작
		// finally 블록에서 인식하기 위해서 선언부를 
		// 위로 이동시킨다.
		OutputStream out =null;
		try {
			out = new FileOutputStream(PATH);
			// 파일 쓰기
			out.write(buffer);
			System.out.println("[INFO]파일 저장 성공 >> " + PATH);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR]지정된 경로를 찾을 수 없음 >> " + PATH);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR]파일 저장 실패 >> " + PATH);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR]알 수 없는 에러 >> " + PATH);
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}







