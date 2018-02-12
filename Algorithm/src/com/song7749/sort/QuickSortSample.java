package com.song7749.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * �� ��Ʈ  ����
 * @author song7749@gmail.com
 *
 */
public class QuickSortSample {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("������ �ʿ��� ���ڸ�  , (comma) �� �̿��ؼ� �Է��ϼ���.EX) 1,2,3,4,5,6");
		System.out.print("���ڸ� �Է� �ϼ��� : ");
		try {
			String[] str = scan.next().split(",");
			int[] data  = new int[str.length];
			for(int i = 0 ; i<str.length;i++) {
				data[i]=Integer.parseInt(str[i].trim());
			}

			System.out.printf("�Էµ� ����� %s �Դϴ�. ", Arrays.toString(data));
			System.out.println();

			quickSort(data, 0, data.length-1);
			System.out.printf("���ĵ� ����� %s �Դϴ�. ", Arrays.toString(data));
		} catch (Exception e) {
			System.err.println("�߸� �Է� �߽��ϴ�.");
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

	public static void quickSort(int[] data, int start, int end) {
		System.out.printf("���� �õ� �� - start: %d , end : %d ", start, end);
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
		System.out.println("swap �õ�  : " + data[a] + " : " + data[b]);

		int tmp = data[a];
		data[a] = data[b];
		data[b] = tmp;
	}
}