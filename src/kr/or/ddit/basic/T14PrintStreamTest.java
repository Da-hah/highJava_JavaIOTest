package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class T14PrintStreamTest {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		FileOutputStream fos = new FileOutputStream("d:/D_Other/print.txt");
		
		//PrintStream 은 모든 타입의 데이터를 출력해 주는 기능을 제공하는 스트림이다.
		
		
		
		PrintStream out = new PrintStream(fos);
		out.print("안녕하세요. PrintStream입니다. \n");
		out.println("안녕하세요. PrintStream입니다2");
		out.println("안녕하세요. PrintStream입니다3");
		out.println("안녕하세요. PrintStream입니다3");
		out.println(3.14);
		out.println(out);
		
		out.close();
		
		//===============================================================================
		
		FileOutputStream fos2 = new FileOutputStream("d:/D_Other/print2.txt");
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(fos2, "CP949"));
		
		pw.print("안녕하세요. PrintWriter 입니다.\n");
		pw.println("안녕하세요. PrintWriter 입니다2");
		pw.println("안녕하세요. PrintWriter 입니다3");
		pw.println(3.14);
		pw.println(pw); // 객체 출력
		
		pw.close();
		
	}
}
