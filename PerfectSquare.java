package com.wgcris.LeetcodeAlgorithm;


import java.util.Arrays;

/*
 * ����һ������n���ҵ��������ٵ�ƽ������1,4,9,16...����ʹ֮��Ϊn
 * 
 */
public class PerfectSquare {
 
	public static  int numSquares(int n){
		int[] dp = new int[n + 1];
	       Arrays.fill(dp, Integer.MAX_VALUE);
	       dp[0] = 0;
	       for(int i = 0; i <= n; i++){
	           for(int j = 1; i + j * j <= n; j++){
	               dp[i  + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
	            }
	       }
	       return dp[n];
	}
	
	public static int numSquares1(int n){
		
	}
	
	public static void main(String[] args){
	//	System.out.println((int)Math.pow((int)Math.sqrt(8), 2));
		System.out.println(numSquares(12));
	
	}
}
