package com.song7749.sequence;

import java.util.Scanner;

/**
 * 
자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.

제한사항
N의 범위 : 100,000,000 이하의 자연수
입출력 예
N	answer
123	6
987	24
입출력 예 설명
입출력 예 #1
문제의 예시와 같습니다.

입출력 예 #2
9 + 8 + 7 = 24이므로 24를 return 하면 됩니다.
 */

public class PlusNumberOfDigits {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
		System.out.print("100,000,000 이하의 자연수를 입력 하세요 : ");

        int number = -1;
        try {
			number = scan.nextInt();
			scan.close();
			solution(number);
		} catch (Exception e) {
			System.err.println("자연수 만 입력 가능 합니다.");
		}        
    }

    public static int solution(int n) {
        int answer = 0;

  		do {
            answer += n % 10;
            n /=10;
        } while(n > 0) ;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(answer);
        return answer;
    }
}