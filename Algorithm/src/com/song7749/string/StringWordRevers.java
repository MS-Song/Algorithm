package com.song7749.string;

import java.util.Scanner;

/**
 문장의 형식을 가진 문자열의 모든 단어를 거꾸로 하시오.
예) 'ABC 123' - 'CBA 321'
 * @author song7749@gmail.com
 *
 */
public class StringWordRevers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("특정한 문자열을 입력하세요. 숫자와 문자 각각 소트합니다. "
				+ "\n EX) ABC 123 --> CBA 321");
		System.out.print("문자열을 입력하세요 : ");

		try {
			String str = scan.nextLine();
			System.out.println("입력된 값은 " + str);
			sort(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

	private static void sort(String str) {
		// 단어를 자른다.
		String[] split  = str.split(" ");
		// 단어 별로 역 소트 한다.
		for(int i=0; i<split.length;i++) {
			split[i] = revers(split[i]);
		}
		str = String.join(" ", split);
		System.out.println("결과값 : " + str);
	}

	private static String revers(String s) {
	  return ( new StringBuffer(s) ).reverse().toString();
	}
}