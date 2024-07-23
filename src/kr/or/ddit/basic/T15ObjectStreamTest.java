package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *	객체 입출력 스트림 예제
 */
public class T15ObjectStreamTest {
	public static void main(String[] args) {
		MemberVo mem1 = new MemberVo("김일규", 23, "대전");
		MemberVo mem2 = new MemberVo("이미숙", 25, "서울");
		MemberVo mem3 = new MemberVo("이평강", 33, "광주");
		MemberVo mem4 = new MemberVo("이종진", 27, "대구");

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("d:/D_Other/memObj.bin");
			
			// 객체 저장기능을 위한 스트림 객체 생성
			oos = new ObjectOutputStream(fos); // obj를 저장할때마다  fos 위치에 저장 
			
			// 객체 저장하기 
			oos.writeObject(mem1); //직렬화가 발생하고 있음
			oos.writeObject(mem2);
			oos.writeObject(mem3);
			oos.writeObject(mem4);
			
			System.out.println("객체 저장 완료");
			
		} catch (IOException ex) {
			
			ex.printStackTrace();
		
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//================================================================ 읽어오기
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("d:/D_Other/memObj.bin"); // 정보가져오기
			ois = new ObjectInputStream(fis);
			
			Object obj = null;
			
			while((obj = ois.readObject()) != null) { 
				// 파일의 마지막에 다다르면 EOFException이 발생한다.  

				//읽어온 객체를 원래의 객체로 캐스팅 후 사용한다.
				MemberVo mv = (MemberVo)obj;
				System.out.println("이름 : "+ mv.getName());
				System.out.println("나이 : "+ mv.getAge());
				System.out.println("주소 : "+ mv.getAddr());
				System.out.println("-------------------------------------");
				
			}
			
		} catch (IOException ex) {
			//ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}


class MemberVo implements Serializable{
	// 자바는 Serializable 인터페이스를 구현한 클래스만 직렬화 할 수 있도록 제한하고 있음
	
	// transient => 직렬화 되지 않았으면 하는 인스턴스 변수에 지정한다.
	//				(static 변수는 직렬화 대상이 아님)
	//				직렬화가 되지 않는 멤버변수는 기본값으로 저장된다.
	//				(참조형 변수 : null, 숫자형 변수 : 0)
	
	private String name;
	private transient int age;
	private String addr;

	public MemberVo(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
}