package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class T02FileTest {
	public static void main(String[] args) throws IOException {
		File f1 = new File("d:/D_Other/sample.txt");
		File f2 = new File("d:/D_Other/test.txt");
		
		if(f1.exists()) {
			System.out.println(f1.getAbsolutePath() + " 은 존재합니다.");
		}else {
			System.out.println(f1.getAbsolutePath()+ " 은 없는 파일입니다.");
			
			if(f1.createNewFile()) {
				System.out.println(f1.getAbsolutePath() + " 파일을 생성했습니다.");
			}
		}
		
		if(f2.exists()) {
			System.out.println(f2.getAbsolutePath() + " 은 존재합니다.");
		}else {
			System.out.println(f2.getAbsolutePath() + " 은 없는 파일입니다.");
			if(f1.createNewFile()) {
				System.out.println(f2.getAbsolutePath() + " 파일을 생성했습니다.");
			}
		}
		System.out.println("======================================================");
		
		File f3 = new File("d:/D_Other");
		File[] files = f3.listFiles();
		for(File f : files) {
			System.out.print(f.getName() + " =>");
			if(f.isFile()) {
				System.out.println(" 파일");
			}else if(f.isDirectory()) {
				System.out.println(" 디렉토리(폴더)");
			}
		}
		System.out.println("======================================================");
		String[] fileNames = f3.list();
		for(String fileName : fileNames) {
			System.out.println(fileName);
		}
		System.out.println("------------------------------------------------------");
		System.out.println();
		
		displayFileList(new File("d:/D_Other"));
		
		
	}
	
	// 지정된 디렉토리(폴더)에 포함된 파일 및 디렉토리 목록을 보여주기 위한 메서드 
	public static void displayFileList(File dir) {
		System.out.println("[" + dir.getAbsolutePath()+"] 디렉토리의 내용");
		
		//디렉토리 안의 모든 파일 목록을 가져온다.
		File[] files = dir.listFiles();
		
		// 하위 디렉토리의 인덱스 정보를 저장하기 위한 List 객체 생성
		List<Integer> subDirIndexList = new ArrayList<Integer>();
		
		// 날짜 정보를 출력하기 위한 포맷터 생성하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		
		for(int i=0; i<files.length; i++) {
			String attr = ""; //파일의 속성 정보 (읽기, 쓰기, 숨김파일, 디렉토리 구분)
			String size = ""; //파일 크기
			
			if(files[i].isDirectory()) {
				attr = "<DIR>";
				subDirIndexList.add(i); 
			}else {
				size = files[i].length() + "";
				attr = files[i].canRead() ? "R" : " "; //읽을 권한 확인 메서드
				attr += files[i].canWrite() ? "W" : " "; // 쓰기 권한 확인 메서드
				attr += files[i].isHidden() ? "H" : " "; // 숨김파일인지 확인 메서드
			}
			
			System.out.printf("%s %-5s %12s %s\n", 
							 sdf.format(new Date(files[i].lastModified())),
							 attr, size, files[i].getName());
		}// for문 끝
		
		int dirCount = subDirIndexList.size(); //폴더 안의 하위 폴더 개수
		int fileCount = files.length - dirCount; //폴더 안의 파일 개수
		
		System.out.println(fileCount + " 개의 파일, " + dirCount + " 개의 디렉토리");
		
		System.out.println();
		
		
		for(int i=0; i< subDirIndexList.size(); i++) {
			// 하위 폴더의 내용들도 출력하기 위해
			// 재귀호출을 한다.
			displayFileList(files[subDirIndexList.get(i)]);
		}
	}
}













