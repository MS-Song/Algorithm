package com.song7749.string;

import java.util.Scanner;

/**
 문장의 형식을 가진 문자열의 모든 단어를 거꾸로 하시오.
예) 'ABC 123' - 'CBA 321'
시간복잡도는 O(n) 이다. 나누기를 하면 안된다.
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
		StringBuffer sb = new StringBuffer();
		String tmp = "";
		for(int i=0 ; i  < str.length() ; i++ ) {
			// 공백을 만나면 다른 글자로 판별 한다.
			if(str.charAt(i) != ' ') {
				tmp = str.charAt(i) + tmp;
			}
			else {
				sb.append(tmp + " ");
				tmp="";
			}
			if(i == str.length()-1) {
				sb.append(tmp);
			}
		}
		System.out.println("결과값 : " + sb.toString());
	}
}