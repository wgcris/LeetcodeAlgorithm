package com.wgcris.LeetcodeAlgorithm;
/**
 * 判断一个数是3的幂，不适用循环或者迭代
 * 思路：求出3的最大幂，然后判断n是否为该最大幂的约数，如果是则为3的幂，否则不是。
 * @author wgcris
 *
 */
public class IsPowerOfThree {
   
	public static boolean isPowerOfThree(int n){
		if(n<=0) return false;
		int maxvalue=(int) Math.pow(3, (int)(Math.log(0x7fffffff)/Math.log(3)));
		
		return maxvalue%n==0;
	}
	
	public static void main(String[] args){
		System.out.println(isPowerOfThree(6));
	
	}
}
