package com.song7749.sequence;

/**
 * �Ǻ���ġ ������ ��/���� ���ڸ� ���� ���� ���� ���ڸ� ���ϰ� �ȴ�.
 * �ִ� ���� N ���� ���� �Ǻ���ġ ������ ¦���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�
 * ������ 0 �� 1�� �Ѵ�.
 *
 * EX) N = 12 �� �� , 0,1,2,3,5,8 // �� : 10
 *
 * @author song7749@gmail.com
 *
 */
public class FibonacciNumberSumary {
	public static void main(String[] args) {
		int N = 12;
		int before = 0;
		int after = 1;
		int sum = 0;

		do {
			int tmp = before;
			before = after;
			after = before + tmp;
			sum += (after) % 2 == 0 ? after : 0;
		} while(after < N) ;
		System.out.println(" �� : "  + sum);
	}
}
