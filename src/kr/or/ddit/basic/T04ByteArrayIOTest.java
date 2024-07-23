package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T04ByteArrayIOTest {
	public static void main(String[] args) throws IOException {
		
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4]; // 데이터 읽을 때 사용할 버퍼용 배열
		
		
		/*// 직접 복사하기
		outSrc = new byte[inSrc.length];
		for(int i = 0; i< inSrc.length; i++) {
			outSrc[i] = inSrc[i];
		}
		System.out.println("직접 복사 후 outSrc => "+ Arrays.toString(outSrc));
		*/
		
		/*//arraycopy를 이용한 배열 복사
		outSrc = new byte[inSrc.length];
		System.arraycopy(inSrc, 0, outSrc, 0, inSrc.length);
		System.out.println("arraycopy를 이용한 복사 후 => "+ Arrays.toString(outSrc));
		*/
		
		// 스트림 객체 생성하기
		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc); //데이터를 입력할때 
		ByteArrayOutputStream baos = new ByteArrayOutputStream();	 // 데이터를 출력할때 
		
//		int data = 0; // 읽어온 바이트형 데이터를 저장하기 위한 변수
		int readBytes = 0; // 읽어온 바이트 개수 저장하기 위한 변수
		
		// read() 메서드 => byte 단위로 데이터를 읽어와 int 형으로 반환한다.
		//				  (더 이상 읽을 데이터가 없으면 -1을 반환한다.)
		while((readBytes = bais.read(temp)) != -1) {
			
			System.out.println("temp => " + Arrays.toString(temp));
			
			baos.write(temp, 0, readBytes); // 0번째 인덱스부터 읽어온 데이터 까지만 복사
			
			
		}
		
		// 출력된 스트림 데이터를 배열로 가져오기
		outSrc = baos.toByteArray();
		
		System.out.println("inSrc => " + Arrays.toString(inSrc));
		System.out.println("outSrc => " + Arrays.toString(outSrc));
		
	}
}
