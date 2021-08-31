package com.song7749.string;

import java.util.Scanner;

/**
 ������ ������ ���� ���ڿ��� ��� �ܾ �Ųٷ� �Ͻÿ�.
��) 'ABC 123' - 'CBA 321'
�ð����⵵�� O(n) �̴�. �����⸦ �ϸ� �ȵȴ�.
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
		StringBuffer sb = new StringBuffer();
		String tmp = "";
		for(int i=0 ; i  < str.length() ; i++ ) {
			// ������ ������ �ٸ� ���ڷ� �Ǻ� �Ѵ�.
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
		System.out.println("����� : " + sb.toString());
	}
}