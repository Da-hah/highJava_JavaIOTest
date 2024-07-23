package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class T11BurfferedIOTest {
	public static void main(String[] args) {
		// 입출력 성능향상을 위해 버퍼를 사용하는 보조스트림
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			
			fos = new FileOutputStream("d:/D_Other/bufferTest.txt");
			
			// 버퍼크기를 지정하지 않으면 기본적으로 버퍼크기는  8192byte(8kb)로 설정된다.
			bos = new BufferedOutputStream(fos, 5); // 5byte로 설정
			
			for(char ch = '1'; ch <= '9' ; ch++) {  
				bos.write(ch); //BufferedOutputStream의 write() >> 버퍼를 다 채우고 한꺼번에 출력한다. >> 입출력의 성능 향상
			}
			System.out.println("작업끝");
			
			bos.flush(); // 작업을 종료하기 전 버퍼에 남아있는 데이터를 모두 출력 시킨다.
					     // 
						 // close() 호출시 자동으로 호출됨.
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				bos.close(); // 보조 스트림만 닫으면 된다.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
