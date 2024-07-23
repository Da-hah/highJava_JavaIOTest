package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class T12BufferedIOTest {
	public static void main(String[] args) {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("./src/kr/or/ddit/basic/T11BurfferedIOTest.java"); // 현재 프로젝트에서 경로 시작  
			br = new BufferedReader(fr); // fr을 버퍼 기능을 사용해 읽을 수 있다
			
//			int data = 0; 
//			while((data = fr.read()) != -1) {
//				System.out.print((char)data);
//			}
			
			String tempStr = null;
			
			int cnt = 1;
			
			while((tempStr = br.readLine()) != null) { // 한 줄 씩 읽음
				System.out.printf("%4d : %s\n",cnt,tempStr);
				cnt++;
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
