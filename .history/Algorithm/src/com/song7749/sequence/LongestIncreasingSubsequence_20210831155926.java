package com.song7749.sequence;

import java.util.Arrays;

/**
 * 정수 배열이 주어지면 가장 긴 커지는 원소들의 집합의 길이를 구하시오.
 *
 * EX)
 * input : [10,9,0,7,2,5]
 * output : 3 // 0,2,5
 *
 * input : [0,8,12,2,6,14,9,5,13,3,11,7,15]
 * output : 6 // 0,2,6,9,11,15
 *
 * @author song7749@gmail.com
 * TODO 아직 마완성
 *
 */

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] seq = {10,9,0,7,2,5};
		//int[] seq = {0,8,12,2,6,14,9,5,13,3,11,7,15};
		int[] ret = new int[seq.length];

		cal(seq,0,seq.length-1,ret);

		System.out.println("결과값" +  Arrays.toString(ret));
	}

	private static void cal(int[] seq, int start, int end, int[] ret) {
		if(start<end) {
			int pivot = start;
			for(int i=0 ; i < end ; i++) {
				if(seq[i] < seq[i+1]) {
					ret[pivot] = seq[i+1];
					pivot++;
				}
			}
			cal(seq, pivot+1, end,ret);
		}
	}

}