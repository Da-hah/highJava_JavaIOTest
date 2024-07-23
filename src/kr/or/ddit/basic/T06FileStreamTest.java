package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class T06FileStreamTest {
	public static void main(String[] args) {
		
		// 파일 저장용 스트림 객체 생성하기 
		FileOutputStream fos = null;
		
		try {
			
			fos = new FileOutputStream("d:/D_Other/out.txt");
			
			for(char ch ='a'; ch <= 'z'; ch++) {
				fos.write(ch);
			}
			
			System.out.println("파일 저장 완료");
			
		} catch (IOException ex) {
			
			ex.printStackTrace();
			
		} finally {
			
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		//======================================================================
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("d:/D_Other/out.txt");
			
			int data = 0;
			
			while((data = fis.read()) != -1) {
				System.out.print((char) data);
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}	
