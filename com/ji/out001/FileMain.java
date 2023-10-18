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
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class FileMain {

	static Scanner s = new Scanner(System.in);
	static boolean b = true;

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

		Scanner s2 = new Scanner(System.in);
		String dir = null;
		String filename = null;

		while (b == true) {

			System.out.println("===== 파일 관리 =====");
			System.out.println("1. 디렉토리 생성");
			System.out.println("2. 파일 생성");
			System.out.println("3. 파일에 내용 쓰기");
			System.out.println("4. 파일 내용 읽기");
			System.out.println("5. 종료");
			System.out.print("번호 입력 : ");

			int i = s2.nextInt();
			System.out.println("==================");

			if (dir == null || filename == null) {

				if (i == 5) {

					exit();
					break;

				} else if (i >= 3 || i == 0){
					
					System.out.println("일단 디렉토리나 파일을 생성해주세요.");
								
					
				} else {

					switch (i) {

					case 1:
						dir = createDir();
						break;

					case 2:
						filename = createFile(dir);
						break;

					}

				}

			} else {

				switch (i) {

				case 1:
					dir = createDir();
					break;

				case 2:
					filename = createFile(dir);
					break;

				case 3:
					writeFile(dir, filename);
					break;

				case 4:
					readFile(dir, filename);
					break;

				case 5:
					exit();
					break;

				default:
					System.out.println("1~5 까지의 정확한 숫자를 입력해주세요 !");
					break;

				}

			}

		}

	s2.close();

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
			System.out.println(FolderDefault + " 폴더 생성 완료.");
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
			out = new FileOutputStream(locale + "/" + loc,true);
			System.out.println(loc + " 파일 생성 완료.");
			return loc;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(locale + "/" + loc+"파일은 이미 있는 파일입니다!");
			return createFile(locale);
		}
	}

	public static void writeFile(String directory, String fileName) throws IOException {

		String res = directory + "/" + fileName;
		FileOutputStream out = new FileOutputStream(res, true);
		OutputStreamWriter outW = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(outW);

		try {
			// 상단 경로 부분에 true를 사용해야 append가 적용
			// true를 사용하지 않으면 append를 해도 덮어쓰기
			System.out.println("현재 선택된 경로 및 파일 : " + res);
			System.out.print("파일에 입력할 텍스트를 입력해주세요 : ");
			String text = s.nextLine();
			bw.append(text + "\n");
			bw.flush();
			System.out.println("입력 완료 !");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

		} catch (Exception e) {
			bw.close();
			e.printStackTrace();
		}

	}

	public static void readFile(String directory, String fileName) throws IOException {

		String res = directory + "/" + fileName;
		FileInputStream fi = new FileInputStream(res);
		InputStreamReader isr = new InputStreamReader(fi);
		BufferedReader br = new BufferedReader(isr);

		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		System.out.println("출력 완료");
	}

	public static void exit() {

		b = false;

	}
}
