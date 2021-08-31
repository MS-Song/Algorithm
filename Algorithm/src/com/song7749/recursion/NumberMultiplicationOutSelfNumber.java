package com.song7749.recursion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 정수로 된 배열이 주어지면,
 * 각 원소가 자신을 뺀 나머지 원소들의 곱셈이 되게 하시오.
 * 단, 나누기 사용 금지, O(n) 시간 복잡도.
	예) [1, 2, 3, 4, 5] - [120, 60, 40, 30, 24]

 * @author song7749@gmail.com
 *
 */
public class NumberMultiplicationOutSelfNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("원소를 입력 하시오.  , (comma) 를 이용해서 입력하세요.EX) 1,2,3,4,5,6");
		System.out.print("숫자를 입력 하세요 : ");
		try {
			String[] str = scan.nextLine().split(",");
			int[] data  = new int[str.length];
			int[] ret = new int[str.length];
			for(int i = 0 ; i<str.length;i++) {
				data[i]=Integer.parseInt(str[i].trim());
			}

			System.out.printf("입력된 결과는 %s 입니다. ", Arrays.toString(data));
			System.out.println();
			cal(data,0,data.length-1,ret);

			System.out.printf("계산 결과는 %s 입니다. ", Arrays.toString(ret));

		} catch (Exception e) {
			System.err.println("잘못 입력 했습니다.");
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

	private static void cal(int[] data, int start, int end, int[] ret) {
		if(start <= end) {
			int sum=1;
			for(int i=0; i <= end ;i++) {
				if(start != i) {
					sum*=data[i];
				}
				ret[start]=sum;
			}
			start++;
			cal(data,start,end,ret);
		}
	}
}
