package com.song7749.string;

import java.util.Scanner;

/**
 ������ ������ ���� ���ڿ��� ��� �ܾ �Ųٷ� �Ͻÿ�.
��) 'ABC 123' - 'CBA 321'
 * @author song7749@gmail.com
 *
 */
public class StringWordRevers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ư���� ���ڿ��� �Է��ϼ���. ���ڿ� ���� ���� ��Ʈ�մϴ�. "
				+ "\n EX) ABC 123 --> CBA 321");
		System.out.print("���ڿ��� �Է��ϼ��� : ");

		try {
			String str = scan.nextLine();
			System.out.println("�Էµ� ���� " + str);
			sort(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

	private static void sort(String str) {
		// �ܾ �ڸ���.
		String[] split  = str.split(" ");
		// �ܾ� ���� �� ��Ʈ �Ѵ�.
		for(int i=0; i<split.length;i++) {
			split[i] = revers(split[i]);
		}
		str = String.join(" ", split);
		System.out.println("����� : " + str);
	}

	private static String revers(String s) {
	  return ( new StringBuffer(s) ).reverse().toString();
	}
}