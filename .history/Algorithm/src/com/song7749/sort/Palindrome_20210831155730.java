package com.song7749.sort;

/**
 * ����(int)�� �־�����, �Ӹ����(palindrome)���� �˾Ƴ��ÿ�.
 * �Ӹ�����̶�, �տ������� ������ �ڿ������� ������ ���� �ܾ ���մϴ�.
 * ��, ������ ���ڿ��� �ٲٸ� �ȵ˴ϴ�.

����)
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
		// ��꿡 ������ �������.
		boolean isMiners = false;
		if(0 > palindrome) {
			isMiners=true;
			palindrome = palindrome * (-1); // ���ȭ ��Ų��.
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