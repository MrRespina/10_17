package com.ji.out001;

import java.io.File;

public class EncodingMain2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File makeFolder = new File("C:/Users/sdedu/Desktop/Respina");
		if(!makeFolder.exists()) {	//exists() : 디렉토리에 해당 폴더가 없을 시
			makeFolder.mkdir();
			System.out.println("폴더 생성 완료.");
		}else {
			System.out.println("폴더가 이미 있습니다.");
		}
		
		
	}

}
