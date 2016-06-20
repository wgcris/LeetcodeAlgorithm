package com.wgcris.LeetcodeAlgorithm;
/*
 * 判断一个数是否是2的幂
 * 如果一个数是2的幂则该数的二进制只有最左边一位是1，所以用n&(n-1)==0进行判断
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
