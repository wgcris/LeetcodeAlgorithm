package com.wgcris.LeetcodeAlgorithm;
/*
 * �ж�һ�����Ƿ���2����
 * ���һ������2����������Ķ�����ֻ�������һλ��1��������n&(n-1)==0�����ж�
 */
public class IsPowerOfTwo {

	public static boolean isPowerOfTwo(int n){
		
		return ((n & (n-1))==0  && n>0);
	}
	
	public static void main(String[] args){
		int n=3;
		System.out.println(isPowerOfTwo(n));
	//	System.out.println(n>>1);
	}
}
