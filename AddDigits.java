package com.wgcris.LeetcodeAlgorithm;
/*
 * 给定一个非负数，每一位相加，重复执行，得到最后的数为个位，
 * eg:38   3+8=11；1+1=2 输出2
 */
public class AddDigits {

	public static  int addDigits(int num){
		if(num==0) return 0;
		int result;
		result=num%9;
		if(result==0) result=9;
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(addDigits(45));
	}

}
