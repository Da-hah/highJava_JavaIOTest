package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class T10FileEncodingTest {
	public static void main(String[] args) throws IOException {
	/*
	 	키보드로 입력한 내용을 파일로 저장하는데
	 	out_utf8.txt 파일은 'UTF-8' 인코딩 방식으로, 
	 	out_ansi.txt 파일은 'MS949' 인코딩 방식으로 저장해보자. 
	 */
		
		// OutputStreamWriter => 이 보조스트림도 출력할 때 '인코딩 방식'을 지정해서 출력할 수 있다.
		
		// 입력문자 처리용 스트림 객체 생성
		InputStreamReader isr = new InputStreamReader(System.in);
		
		// 파일 출력용 스트림 객체 생성
		FileOutputStream fos1 = new FileOutputStream("d:/D_Other/out_utf8.txt");
		FileOutputStream fos2 = new FileOutputStream("d:/D_Other/out_ansi.txt");
		
		// 문자 출력을 보조해주는 보조 스트림 객체 생성
		OutputStreamWriter osw1 = new OutputStreamWriter(fos1, "UTF-8");
		OutputStreamWriter osw2 = new OutputStreamWriter(fos2, "CP949");
		
		System.out.println("아무거나 입력");
		
		int data = 0;
		
		while((data = isr.read()) != -1) {
			osw1.write(data);
			osw2.write(data);
		}
		
		System.out.println("저장 작업 완료!");
		
		// 사용한 스트림 객체 닫기
		isr.close();
		osw1.close();
		osw2.close();
	}
}
