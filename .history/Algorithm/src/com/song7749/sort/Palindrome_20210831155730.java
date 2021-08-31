package com.song7749.sort;

/**
 * 정수(int)가 주어지면, 팰린드롬(palindrome)인지 알아내시오.
 * 팰린드롬이란, 앞에서부터 읽으나 뒤에서부터 읽으나 같은 단어를 말합니다.
 * 단, 정수를 문자열로 바꾸면 안됩니다.

예제)
Input: 12345
Output: False

Input: -101
Output: False

Input: 11111
Output: True

Input: 12421
Output: True

 * @author song7749@gmail.com
 *
 */
public class Palindrome {

	public static void main(String[] args) {
		for(int i : new int[]{12345,-101,11111,12421}) isPalindrome(i);
	}

	private static void isPalindrome(int palindrome) {
		// 계산에 음수는 관계없다.
		boolean isMiners = false;
		if(0 > palindrome) {
			isMiners=true;
			palindrome = palindrome * (-1); // 양수화 시킨다.
		}
		System.out.println("Input : " + (isMiners ? palindrome*(-1) : palindrome));
		System.out.println("Output : " + (palindrome == flip(palindrome)));
	}

    public static int flip(int num){
        int result=0;
        while(num>0){
            result= result * 10 + num % 10;
            num /= 10;
        }
        return result;
    }
}