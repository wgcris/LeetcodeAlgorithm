package com.wg.leetcode;
/*
 * leetcode283:给定一个数组，将数组中的零移到数组的后面,同时保持数组非零元素的相对顺序不变	。
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
