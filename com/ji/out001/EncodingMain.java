package com.ji.out001;

import java.awt.image.DataBufferDouble;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

//C:\Users\sdedu\Desktop

public class EncodingMain {

	public static void main(String[] args) {
		
		/*FileOutputStream out = null;
		OutputStreamWriter outW = null;

		
		// TODO Auto-generated method stub
		try {
			out = new FileOutputStream("C:\\Users\\sdedu\\Desktop\\Encoding.txt", true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			outW = new OutputStreamWriter(out, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedWriter bw = new BufferedWriter(outW);
		try {
			//	상단 경로 부분에 true를 사용해야 append가 적용
			//	true를 사용하지 않으면 append를 해도 덮어쓰기
			bw.write("호에엥\n");
			bw.write("123\n");
			bw.write("호에엥\n");	//덮어쓰기
			bw.append("12345\n");	//이어쓰기
			bw.append("56789\n");
			bw.flush();
			System.out.println("성공?");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		BufferedReader br = null;
		
		try {
			
			FileInputStream fi = new FileInputStream("C:/Users/sdedu/Desktop/Encoding.txt");
			InputStreamReader isr = new InputStreamReader(fi);
			
			br = new BufferedReader(isr);
			String line = null;
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		try {
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
