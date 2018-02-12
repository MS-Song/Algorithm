package com.song7749;

import java.util.Scanner;

/**
0���� ũ�ų� ����, 99���� �۰ų� ���� ������ �־��� �� ������ ���� ������ �� �� �ִ�.
���� �־��� ���� 10���� �۴ٸ� �տ� 0�� �ٿ� �� �ڸ� ���� �����, �� �ڸ��� ���ڸ� ���Ѵ�.
�� ����, �־��� ���� ���� ������ �ڸ� ���ڿ� �տ��� ���� ���� ���� ������ �ڸ� ���ڸ� �̾� ���̸� ���ο� ���� ���� �� �ִ�.

���� ���� ����.
26���� �����Ѵ�.
2+6 = 8�̴�. ���ο� ���ڴ� 68�̴�.
6+8 = 14�̴�. ���ο� ���ڴ� 84�̴�.
8+4 = 12�̴�. ���ο� ���ڴ� 42�̴�.
4+2 = 6�̴�. ���ο� ���ڴ� 26�̴�.

���� ���� 4������ ���� ���ڷ� ���ƿ� �� �ִ�.
���� 26�� ����Ŭ�� ���̴� 4�̴�.

N�� �־����� ��, N�� ����Ŭ�� ���̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */
public class NumberNextReturn {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("0~99 ������ ������ �Է��� �ּ��� : ");
		int number = -1;
		try {
			number = scanner.nextInt();
			scanner.close();
			cal(number,number,0);
		} catch (Exception e) {
			System.err.println("0~99 ������ ������ �Է� ���� �մϴ�.");
		}
	}
	public static void cal(int origin, int next, int count) {
		int first = next < 10 ? 0 : next/10;
		int second = next%10;
		int sum = first+second;
		next = (second * 10) + (sum<10 ? sum : sum%10);
		count++;
		System.err.println(count + "ȸ ��� : " + first + " + " + second + " = " + sum + ", ���ο� ���� : " + next);
		if(origin == next)
			System.out.println("�� : ���ȸ���� " + count + " ȸ");
		else
			cal(origin,next,count);
	}
}