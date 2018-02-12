package com.song7749.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 퀵 소트  구현
 * @author song7749@gmail.com
 *
 */
public class QuickSortSample {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("정렬이 필요한 숫자를  , (comma) 를 이용해서 입력하세요.EX) 1,2,3,4,5,6");
		System.out.print("숫자를 입력 하세요 : ");
		try {
			String[] str = scan.next().split(",");
			int[] data  = new int[str.length];
			for(int i = 0 ; i<str.length;i++) {
				data[i]=Integer.parseInt(str[i].trim());
			}

			System.out.printf("입력된 결과는 %s 입니다. ", Arrays.toString(data));
			System.out.println();

			quickSort(data, 0, data.length-1);
			System.out.printf("정렬된 결과는 %s 입니다. ", Arrays.toString(data));
		} catch (Exception e) {
			System.err.println("잘못 입력 했습니다.");
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

	public static void quickSort(int[] data, int start, int end) {
		System.out.printf("정렬 시도 중 - start: %d , end : %d ", start, end);
		System.out.printf(", data : %s \n\r", Arrays.toString(data));

		if(start < end) {
			int pivot  = start;
			for(int i= start ; i < end ; i++) {
				if(data[i] < data[end]) {
					swap(data, i, pivot);
					pivot++;
				}
			}
			swap(data,pivot,end);
			quickSort(data, start, pivot-1);
			quickSort(data, pivot+1, end);
		}
	}

	private static void swap(int[] data, int a, int b) {
		System.out.println("swap 시도  : " + data[a] + " : " + data[b]);

		int tmp = data[a];
		data[a] = data[b];
		data[b] = tmp;
	}
}