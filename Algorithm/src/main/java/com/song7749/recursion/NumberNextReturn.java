package com.song7749.recursion;

import java.util.Scanner;

/**
0보다 크거나 같고, 99보다 작거나 같은 정수가 주어질 때 다음과 같은 연산을 할 수 있다.
먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고, 각 자리의 숫자를 더한다.
그 다음, 주어진 수의 가장 오른쪽 자리 숫자와 앞에서 구한 합의 가장 오른쪽 자리 숫자를 이어 붙이면 새로운 수를 만들 수 있다.

다음 예를 보자.
26부터 시작한다.
2+6 = 8이다. 새로운 숫자는 68이다.
6+8 = 14이다. 새로운 숫자는 84이다.
8+4 = 12이다. 새로운 숫자는 42이다.
4+2 = 6이다. 새로운 숫자는 26이다.

위의 예는 4번만에 원래 숫자로 돌아올 수 있다.
따라서 26의 사이클의 길이는 4이다.

N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성하시오.
 */
public class NumberNextReturn {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("0~99 까지의 정수를 입력해 주세요 : ");
		int number = -1;
		try {
			number = scanner.nextInt();
			scanner.close();
			cal(number,number,0);
		} catch (Exception e) {
			System.err.println("0~99 까지의 정수만 입력 가능 합니다.");
		}
	}
	public static void cal(int origin, int next, int count) {
		int first = next < 10 ? 0 : next/10;
		int second = next%10;
		int sum = first+second;
		next = (second * 10) + (sum<10 ? sum : sum%10);
		count++;
		System.err.println(count + "회 계산 : " + first + " + " + second + " = " + sum + ", 새로운 숫자 : " + next);
		if(origin == next)
			System.out.println("답 : 계산회수는 " + count + " 회");
		else
			cal(origin,next,count);
	}
}