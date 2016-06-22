package com.wg.leetcode;
/*
 * 求n所有的素数
 * 思路：将2的倍数，3的倍数，4...一次去除，剩下的就是小于n的所有素数
 */
public class CountPrimes {
  public static int countPrimes(int n){
	  boolean[] b=new boolean[n];
	  int count=0;
	  for(int i=2;i<n;i++){
		  if(!b[i]) count++;
		  for(int j=i;j*i<n;j++){
			  b[j*i]=true;
		  }
	  }
	  return count;
  }
}
