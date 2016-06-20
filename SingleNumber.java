package com.wgcris.LeetcodeAlgorithm;

import javax.naming.spi.DirStateFactory.Result;

/*
 * 136: ����һ���������飬ÿһ��Ԫ�ض��������Σ�����һ��Ԫ��ֻ����һ�Σ��ҵ���Ԫ�ء�
 * 137������һ���������飬ÿһ��Ԫ�ض��������Σ�����һ��Ԫ��ֻ����һ�Σ��ҵ���Ԫ�ء�
 */
public class SingleNumber {

	/**
	 * ˼·������Ԫ������������Ԫ����ͬ�����Ϊ0�����������Ϊ1;������������Ԫ�ؽ�����򣬽������ֻ����һ�ε�Ԫ�أ�
	 * @param nums
	 * @return
	 */
	public static int singleNumber1(int[] nums){
		int result=nums[0];
		for(int i=1;i<nums.length;i++){
			result^=nums[i];
		}
		return result;
		
	}
	/**
	 * 137��
	 * ˼·������ÿ��Ԫ����һ��32Ϊ�Ķ�������������ÿһλ����1or0,���������飬ͳ��ÿһλ��1���ֵĴ���count���ض���3N����3N+1����countmod3,�������ֻ����һ�ε�Ԫ��
	 * @param nums
	 * @return
	 */
	public static int singleNumber2(int[] nums){
	  int result=0;
	  //32λ����λ����ͳ��
	  for(int i=0;i<32;i++){
		  int count=0;
		  int mask=1<<i;
		  for(int j=0;j<nums.length;j++){
			  //ÿһλ���������㣬�ж��Ƿ�Ϊ1
			 if((nums[j] & mask) !=0) count++;			  
		  }
		  if(count%3==1) result |=mask; 
	  }
	  return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
