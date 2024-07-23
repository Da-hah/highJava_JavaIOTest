package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *	기본 타입 입출력을 위한 보조스트림
 */
public class T13DataIOStreamTest {
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos = new FileOutputStream("d:/D_Other/test.dat");
		
		// 출력용 데이터를 해당 자료형에 맞게 출력해 주기 위해 보조스트림 객체 사용 
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF("홍길동"); //  문자열 데이터 출려(UTF-8)
		dos.writeInt(17);		// 정수형 데이터 출력
		dos.writeFloat(3.14f);	// 실수형 ( float) 데이터 출력
		dos.writeDouble(3.14);	// 실수형 (double) 데이터 출력
		dos.writeBoolean(true);	// boolean형 데이터 출력
		
		System.out.println("출력 완료 ...");
		
		dos.close();
		
		//============================================================
		// 출력한 데이터 읽어오기
		
		FileInputStream fis = new FileInputStream("d:/D_Other/test.dat");
		
		DataInputStream dis = new DataInputStream(fis);
		
		System.out.println("문자열 데이터 : "+ dis.readUTF());
		System.out.println("정수형 데이터 : "+ dis.readInt());
		System.out.println("실수형(float) 데이터 : "+ dis.readFloat());
		System.out.println("실수형(double) 데이터 : "+ dis.readDouble());
		System.out.println("논리형 데이터 : "+ dis.readBoolean());
		
		// 값을 넣은 순서대로 타입을 변환해줘야 처음 넣은 값 그대로 복원이 가능하다.
		
		System.out.println("데이터 읽기 완료 ... ");
		
		dis.close();
	}
}
