package com.ji.out001;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//	CPU : 연산장치
//	RAM : 저장장치(임시) - 재부팅하면 날아감.
//		static / stack - 프로그램을 끄면 날아감.
//		heap - 자동으로 안날아감(GC있으면 자동으로 날아감)
//	HDD : 저장장치(영구) - 폴더 / 파일
//	프로그램에서는 Data를 외부에서 읽고, 다시 외부로 출력하는 작업이 많음.
//	Data는 사용자로부터 키보드 입력을 받거나 파일, 네트워크에서 입력될수 있음. (Input)
//	반대로 모니터를 통해 출력될 수 있고 파일, 네트워크로도 출력될 수 있음. (Output)

//	System.in > InputStream
//	System.out > PrintStream

//	기본형
//	InputStream	: 장치(키보드,파일,네트워크,...) > 프로그램으로 입력 (1byte)
//	InputStreamreader : 장치 > 프로그램 (2byte)
//	BufferdReader : (1String > line(엔터 기준))

//	OutputStream : 프로그램 결과 > 장치(파일,네트워크,...) (1byte)
//	OutputStreamWriter : 2byte
//	BufferdWriter : 1String > line

//	개조형
//	PrintStream(OutputStream 개조) : 쓰기 편하게 유용한 메소드들 추가 - sysout
//	FileReader(InputStreamReader 개조) : 파일에서 Data를 읽어오기 편하게
//	FileWriter(OutputStreamWriter 개조) : 데이터 출력 편하게 

public class FileWriterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);	
		String res = "C:\\Users\\sdedu\\Desktop\\pin\\Res.txt";
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(res,true);
			bw = new BufferedWriter(fw);
			
			//	상단 경로 부분에 true를 사용해야 append가 적용
			//	true를 사용하지 않으면 append를 해도 덮어쓰기
			System.out.println("현재 선택된 경로 및 파일 : "+res);
			System.out.print("파일에 입력할 텍스트를 입력해주세요 : ");
			String text = s.nextLine();
			bw.append(text+"\n");
			bw.flush();
			System.out.println("입력 완료 !");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
