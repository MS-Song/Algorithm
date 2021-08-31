package com.song7749.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 버블 소트 구현
 * @author song7749@gmail.com
 *
 */
public class BubleSortSample {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("정렬이 필요한 숫자를  , (comma) 를 이용해서 입력하세요.EX) 1,2,3,4,5,6");
		System.out.print("숫자를 입력 하세요 : ");
		try {
			String[] str = scan.nextLine().split(",");
			int[] data  = new int[str.length];
			for(int i = 0 ; i<str.length;i++) {
				data[i]=Integer.parseInt(str[i].trim());
			}

			System.out.printf("입력된 결과는 %s 입니다. ", Arrays.toString(data));
			System.out.println();

			// 버블 소트 구현
			bubleSort(data);

			System.out.printf("정렬된 결과는 %s 입니다. ", Arrays.toString(data));
		} catch (Exception e) {
			System.err.println("잘못 입력 했습니다.");
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

	private static void bubleSort(int[] data) {
		int temp=0;
		int count=data.length;
		int times = 0;
		for(int i=0; i<count; i++) {
			for(int j=0; j<count -(i+1); j++) {
				if(data[j] > data[j+1]) {
					temp = data[j+1];
					data[j+1] = data[j];
					data[j]= temp;
				}
				System.out.println((++times) + "회 정렬 진행중 : " + Arrays.toString(data));
			}
		}
	}
}