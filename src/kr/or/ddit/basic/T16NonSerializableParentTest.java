package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class T16NonSerializableParentTest {
/*
 	부모클래스가 Serializable인터페이스를 구현하고 있지 않을 경우 부모객체의 필드값 처리 방법
 	
 	1. 부모클래스가 Serializable 인터페이스를 구현하도록 해야한다.
 	2. 자식클래스에 writeObject()와 readObject() 메서드를 구현하여 부모객체의 필드값을 직접 처리할 수 있도록 한다.
 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectOutputStream oos = 
				new ObjectOutputStream(
						new FileOutputStream("d:/D_Other/nonSerializableTest.bin"));
		Child child = new Child();
		child.setParentName("부모");
		child.setChildName("자식");
		
		oos.writeObject(child); //직렬화
		System.out.println("객체 저장 완료");
		oos.close();
		//=====================================
		
		ObjectInputStream ois = 
				new ObjectInputStream(
						new FileInputStream("d:/D_Other/nonSerializableTest.bin"));
		
		Child child2 = (Child) ois.readObject(); //역직렬화
		System.out.println("parentName : " + child2.getParentName());
		System.out.println("childName : " + child2.getChildName());
		ois.close();
	}
}
 
// Serializable 인터페이스를 구현하지 않은 부모클래스

class Parent {
	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}

// Serializable 인터페이스를 구현한 자식 클래스
class Child extends Parent implements Serializable {
	private String childName;

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}
	
	/**
	 * 직렬화 될 때 자동으로 호출됨
	 * (접근제한자가 private이 아니면 호출되지 않음)
	 * @param oos
	 */
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.writeUTF(getParentName());
		oos.defaultWriteObject(); // 디폴트 기능을 호출하는 메서드
	}
	
	/**
	 * 역직렬화가 될 때 자동으로 호출됨
	 * (접근제한자가 private이 아니면 자동호출되지 않음)
	 * @param ois
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		setParentName(ois.readUTF()); // 객체를 읽어와서 저장?
		ois.defaultReadObject(); // 디폴트 기능을 호출하는 메서드 
	}
	
}















