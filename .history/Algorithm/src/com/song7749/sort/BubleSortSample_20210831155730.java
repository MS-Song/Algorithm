package com.song7749.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ���� ��Ʈ ����
 * @author song7749@gmail.com
 *
 */
public class BubleSortSample {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("������ �ʿ��� ���ڸ�  , (comma) �� �̿��ؼ� �Է��ϼ���.EX) 1,2,3,4,5,6");
		System.out.print("���ڸ� �Է� �ϼ��� : ");
		try {
			String[] str = scan.nextLine().split(",");
			int[] data  = new int[str.length];
			for(int i = 0 ; i<str.length;i++) {
				data[i]=Integer.parseInt(str[i].trim());
			}

			System.out.printf("�Էµ� ����� %s �Դϴ�. ", Arrays.toString(data));
			System.out.println();

			// ���� ��Ʈ ����
			bubleSort(data);

			System.out.printf("���ĵ� ����� %s �Դϴ�. ", Arrays.toString(data));
		} catch (Exception e) {
			System.err.println("�߸� �Է� �߽��ϴ�.");
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
				System.out.println((++times) + "ȸ ���� ������ : " + Arrays.toString(data));
			}
		}
	}
}