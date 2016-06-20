package com.wgcris.LeetcodeAlgorithm;

public class IsPowerOfFour {
  
	public static boolean isPowerOfFour(int num){
		
		if(num<=0) return false;		
		
		return (num &(num-1))==0?(num &(0x55555555))!=0:false;
	}
	
	public static void main(String[] args){
		System.out.println(isPowerOfFour(8));
	}
}
