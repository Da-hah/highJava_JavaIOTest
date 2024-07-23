package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Homework {
	public static void main(String[] args) {
		/*
		 	'd:/D_Other/'에 있는 'Tulips.jpg'파일을

			'복사본_Tulips.jpg'로 복사하는 프로그램을
			
			작성하시오.
			
		 */
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("d:/D_Other/Tulips.jpg");
			fos = new FileOutputStream("d:/D_Other/복사본_Tulips.jpg");
			
			int data = 0;
			while((data = fis.read()) != -1) {
				fos.write(data);
			}
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
