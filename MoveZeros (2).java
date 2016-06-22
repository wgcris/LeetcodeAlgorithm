package com.wg.leetcode;
/*
 * leetcode283:����һ�����飬�������е����Ƶ�����ĺ���,ͬʱ�����������Ԫ�ص����˳�򲻱�	��
 */

public class MoveZeros {

	public static void moveZeros(int[] nums){
		if(nums==null || nums.length==0) return ;
		int index=0;
		for(int num:nums){
			if(num!=0)nums[index++]=num;
		}
		while(index<nums.length){
			nums[index++]=0;
		}
		for(int i:nums){
			System.out.print(i+" ");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={0,1,0,3,12};
		moveZeros(nums);
	}

}
