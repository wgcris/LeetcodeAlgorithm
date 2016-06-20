package com.wgcris.LeetcodeAlgorithm;
/*
 * 根据丑陋数的定义，我们将给定数除以2、3、5，直到无法整除，也就是除以2、3、5的余数不再为0时停止。
 * 这时如果得到1，说明是所有因子都是2或3或5，如果不是1，则不是丑陋数。
 */
public class UglyNumber {
  
	
	public static boolean isUgly(int num){
		if(num<=0)return false;
		if(num==1) return true;
		
		while(num>=2 &&num%2==0) num/=2;
		while(num>=3 &&num%3==0) num/=3;
		while(num>=5 &&num%5==0) num/=5;
		
		return num==1;
	}
}
