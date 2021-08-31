package com.song7749.sequence;

/**
 * 피보나치 수열은 앞/뒤의 숫자를 더한 값이 다음 숫자를 정하게 된다.
 * 최대 값이 N 보다 작은 피보나치 수열의 짝수를 구하는 프로그램을 작성하시오
 * 시작은 0 과 1로 한다.
 *
 * EX) N = 12 일 때 , 0,1,2,3,5,8 // 답 : 10
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
		System.out.println(" 답 : "  + sum);
	}
}
