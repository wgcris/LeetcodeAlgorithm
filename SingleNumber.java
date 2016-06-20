package com.wgcris.LeetcodeAlgorithm;

import javax.naming.spi.DirStateFactory.Result;

/*
 * 136: 给定一个整数数组，每一个元素都出现两次，除了一个元素只出现一次，找到该元素。
 * 137：给定一个整数数组，每一个元素都出现三次，除了一个元素只出现一次，找到该元素。
 */
public class SingleNumber {

	/**
	 * 思路：两个元素异或，如果两个元素相同异或结果为0，否则异或结果为1;将数组中所有元素进行异或，结果就是只出现一次的元素，
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
	 * 137，
	 * 思路：考虑每个元素是一个32为的二进制数，这样每一位上是1or0,对整个数组，统计每一位上1出现的次数count，必定是3N或者3N+1，对countmod3,结果就是只出现一次的元素
	 * @param nums
	 * @return
	 */
	public static int singleNumber2(int[] nums){
	  int result=0;
	  //32位，逐位进行统计
	  for(int i=0;i<32;i++){
		  int count=0;
		  int mask=1<<i;
		  for(int j=0;j<nums.length;j++){
			  //每一位进行与运算，判断是否为1
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
