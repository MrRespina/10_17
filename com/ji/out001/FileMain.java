package com.ji.out001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class FileMain {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void start() throws IOException {

		String dir = createDir();
		String filename = createFile(dir);
		writeFile(dir,filename);
		
	}

	public static String createDir() {

		Scanner s = new Scanner(System.in);
		String FolderDefault = "C:/Users/sdedu/Desktop/";
		File makeFolder = null;
		System.out.print("만들 폴더의 이름을 입력해주세요 : ");
		String folderName = s.nextLine();
		if (folderName == null || (folderName.equals(""))) {
			System.out.println("만들 폴더를 입력해주세요 !");
			s.nextLine();
			createDir();
		} else {
			FolderDefault += folderName;
			makeFolder = new File(FolderDefault);
		}

		if (!makeFolder.exists()) { // exists() : 디렉토리에 해당 폴더가 없을 시
			makeFolder.mkdir();
			System.out.println(FolderDefault+" 폴더 생성 완료.");
		} else {
			System.out.println("해당 이름의 폴더가 이미 있습니다.");
		}

		return FolderDefault;

	}

	public static String createFile(String locale) throws IOException {

		FileOutputStream out = null;
		System.out.print("만들 파일의 이름을 입력해주세요 : ");
		String loc = s.nextLine();
		
		try {
			out = new FileOutputStream(locale+"/"+loc, true);
			System.out.println(loc+" 파일 생성 완료.");
			return loc;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(locale+"/"+loc);
			return createFile(locale);
		}
	}
	
	public static void writeFile(String directory,String fileName) throws IOException {
		
		String res = directory+"/"+fileName;
		FileOutputStream out = new FileOutputStream(res,true);
		OutputStreamWriter outW = new OutputStreamWriter(out, "UTF-8");	
		BufferedWriter bw = new BufferedWriter(outW);
		
		try {
			//	상단 경로 부분에 true를 사용해야 append가 적용
			//	true를 사용하지 않으면 append를 해도 덮어쓰기
			System.out.println("현재 선택된 경로 및 파일 : "+res);
			System.out.print("파일에 입력할 텍스트를 입력해주세요 : ");
			String text = s.nextLine();
			bw.append(text);
			bw.flush();
			System.out.println("입력 완료 !");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
		} catch(Exception e) {
			bw.close();
			e.printStackTrace();
		}
		
	}

}
