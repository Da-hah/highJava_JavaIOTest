package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *	 파일 읽기 예제
 */
public class T05FileStreamTest {
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("d:/D_Other/test2.txt");
			int data = 0;
			
			while((data = fis.read()) != -1) { // 한글은 1byte로 표현할 수 없어서 글씨가 깨져서 나온다
				// 읽어온 데이터 콘솔에 출력하기
				System.out.print((char)data);
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
