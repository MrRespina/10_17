package com.ji.use002;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

//이름/yyyy.MM.dd/국어/수학/영어 입력받아
//나이, 총점, 평균값 출력

public class ExMain1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			start();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String[] getInfo() {

		Scanner s = new Scanner(System.in);
		System.out.print("이름/생년월일(yyyy.mm.dd)/국어점수/수학점수/영어점수를 입력해주세요 : ");
		String info = s.nextLine();
		String[] arr = null;

		// "/"를 단위로 잘라내서 배열에 넣음.
		if (info != null) {
			arr = info.split("/");
		}

		if (arr.length > 5) {
			System.out.println("정확한 값을 입력해주세요 !");
			return getInfo();

		}

		s.close();

		return arr;

	}

	public static void printInfo(String[] arr) throws ParseException {

		int sum = 0, age = 0;
		// 나이 구하는 과정.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
		Date d;
		d = sdf.parse(arr[1]);
		
		Date now = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy", Locale.KOREA);
		String nowYr = sdf1.format(now);
		String birthdayUr = sdf1.format(d);
		int ny = Integer.parseInt(nowYr);
		int by = Integer.parseInt(birthdayUr);
		age = ny - by + 1;

		// i = 2인 이유는 이미 정해진 순서 내에 점수를 입력받는 문자열은 2번,3번,4번밖에 없기 떄문.
		for (int i = 2; i < arr.length; i++) {
			sum += Integer.parseInt(arr[i]);
		}

		// 출력
		System.out.println("이름 : " + arr[0]);
		System.out.println("나이 : " + age);
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + (sum / 3.0));

	}

	public static void start() throws ParseException {

		String[] result = getInfo();
		printInfo(result);

	}

}
