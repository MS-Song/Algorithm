package com.song7749.recursion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ������ �� �迭�� �־�����,
 * �� ���Ұ� �ڽ��� �� ������ ���ҵ��� ������ �ǰ� �Ͻÿ�.
 * ��, ������ ��� ����, O(n) �ð� ���⵵.
	��) [1, 2, 3, 4, 5] - [120, 60, 40, 30, 24]

 * @author song7749@gmail.com
 *
 */
public class NumberMultiplicationOutSelfNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("���Ҹ� �Է� �Ͻÿ�.  , (comma) �� �̿��ؼ� �Է��ϼ���.EX) 1,2,3,4,5,6");
		System.out.print("���ڸ� �Է� �ϼ��� : ");
		try {
			String[] str = scan.nextLine().split(",");
			int[] data  = new int[str.length];
			int[] ret = new int[str.length];
			for(int i = 0 ; i<str.length;i++) {
				data[i]=Integer.parseInt(str[i].trim());
			}

			System.out.printf("�Էµ� ����� %s �Դϴ�. ", Arrays.toString(data));
			System.out.println();
			cal(data,0,data.length-1,ret);

			System.out.printf("��� ����� %s �Դϴ�. ", Arrays.toString(ret));

		} catch (Exception e) {
			System.err.println("�߸� �Է� �߽��ϴ�.");
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
