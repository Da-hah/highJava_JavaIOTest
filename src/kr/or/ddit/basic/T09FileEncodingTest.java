package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class T09FileEncodingTest {
/*
 	파일 인코딩 방식에 대하여
 	
 	한글인코딩 방식은 지금은 크게 UTF-8 과 EUC-KR 방식 두가지로 나누어 볼 수 있다.
 	원래 한글 윈도우는 CP949방식을 사용했는데, 윈도우를 개발한 마이크로소프트에서 EUC-KR 방식에서 
 	확장하였기 때문에 MS949 라고도 부른다 
 	한글 윈도우의 메모장에서 말하는 ANSI인코딩이란 CP949(Code page 949)를 의미한다.
 	
 	- CP949(MS949) => 윈도우의 한글 인코딩 방식(ANSI 계열)
 	- UTF-8 => 유니코드 UTF-8 인코딩 방식
 	- US-ASCII => 영문 전용 인코딩 방식
 	
 	 => ASCII 코드는 영어를 표기하기 위해 만든 코드로 규격 자체에 한글이 없었다가 
 	        나중에 여기에 한글이 포함되면서 EUC-KR, CP949 등의 인코딩 방식이 추가되었음. 
 	        
 	참고) 
 	ASCII => extends ASCII(ISO8859-1) => 조합형, 완성형(KSC5601) => 윈도우계열 : CP949
 															  => 유닉스계열 : EUC-KR
 															  
 	=> ANSI계열 => EUC-KR 
 	=> 유니코드(UTF-8) 
 */
	
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		
		try {
			fis = new FileInputStream("d:/D_Other/test_ansi.txt");
//			fis = new FileInputStream("d:/D_Other/test_utf8.txt");
			
			// 파일인코딩 정보를 이용하여 읽어오기
			// ex) new InputStreamReader(바이트기반스트림객체, 인코딩방식);
			isr = new InputStreamReader(fis, "EUC-KR");
			
			int data = 0;
//			while((data = fis.read()) != -1) { // 인코딩 하지 않았을때는 한글이 깨짐
			while((data = isr.read()) != -1) {
				System.out.print((char)data);
			}
			System.out.println();
			System.out.println("출력 끝 ... ");
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				isr.close(); // 보조스트림만 닫아도 된다
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
