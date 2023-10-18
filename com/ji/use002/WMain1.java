package com.ji.use002;

//Wrapper Class > 포장 객체
// Integer, Double , Boolean , ...
// 기본 자료형을 객체로 다루기 위해 사용하는 class

// Boxing 	: 기본형 > 래퍼 클래스
// UnBoxing	: 래퍼 클래스 > 기본형

// 문자열 > 숫자	: Integer, Double class들의 static 함수를 사용.
// 숫자 > 문자열	: Integer.toString, Double.toString

// 1. 객체나 클래스가 제종하는 method를 사용할 때
// 2. 클래스가 제공하느 상수를 사용(MIN_VALUE,MAX_VALUE)
// 3. (v) 숫자 <-> 문자간 형변환.

//	기본 타입				래퍼 클래스
//				> 박싱
//				< 언 박싱
//	int					Integer
//	double				Double

public class WMain1 {
	
	public static void main(String[] args) {
		
		int a = 10;
		double aa = (double)a;
		
		String s = "100";
		Integer s1 = new Integer(s);
		System.out.println(s1.getClass());
		s1.intValue();	//	Integer -> int : unboxing
		System.out.println(s1);
		System.out.println(s1.TYPE);
		
		// 기본형 > 객체형 : boxing
		double d = 123.45;
		Double dd = new Double(d);
		
		// 위 과정을 자동으로 해줌 ( auto-boxing )
		Integer g = 10;
		int gg = g;
		
		// 객체형 > 기본형 : unboxing
		Boolean b = new Boolean(true);
		boolean bb = b.booleanValue();
		
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		
		System.out.println(max+" "+min);
		
		int i = 10;
		String st = Integer.toString(i);
		System.out.println(st);
		
		// int 자료형 값을 2진수 형태로(String)
		String num = Integer.toBinaryString(1235);
		System.out.println(num);
		
		// STring > 기본형 (다이렉트는 힘들고 객체형을 거쳐야 함.)
		String k = "623.5";
		Double k2 = Double.parseDouble(k);
		double k3 = k2.doubleValue();
		
		// 약식형
		String kk = "123";
		int kk2 = Integer.parseInt(kk);
		
	}

}
