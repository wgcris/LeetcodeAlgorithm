package com.wg.leetcode;
/*
 * ��n���е�����
 * ˼·����2�ı�����3�ı�����4...һ��ȥ����ʣ�µľ���С��n����������
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
