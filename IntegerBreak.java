package com.wgcris.LeetcodeAlgorithm;
/*
 * ����һ��������n������һ�������sum������������������������n����m1,m2..m�˻��������⼸����֮�͵���n=m1+m2..m
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * eg.
 *  7 = 3 * 2 * 2
	8 = 3 * 3 * 2
	9 = 3 * 3 * 3
	10 = 3 * 3 * 2 * 2
	11 = 3 * 3 * 3 * 2
	12 = 3 * 3 * 3 * 3
	13 = 3 * 3 * 3 * 2 * 2
 */

public class IntegerBreak {
  
	
	public static int interBreak(int n){
		if(n==2||n==3) return n-1;
		if(n==4)return 4;
		int temp=n;
		int sum=1;
		while(temp>4){
			temp=temp-3;
			sum=sum*3;
		}
		return sum*temp;
	}
	
	public static void main(String[] args){
		System.out.println(interBreak(10));
	}
}
