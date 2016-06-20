package com.wgcris.LeetcodeAlgorithm;
/*
 * 将数组中的所有0移到数组最后面，同时保证相对顺序不变
 */
public class MoveZeros {

	public static void moveZeros(int[]nums){
		if(nums==null || nums.length==0)
			return;
		int insertPos=0;
		for(int num:nums)
			if(num!=0)
				nums[insertPos++]=num;
		while(insertPos<nums.length){
			nums[insertPos++]=0;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] nums={0,1,0,3,12};
      moveZeros(nums);
      for(int i:nums){
    	  System.out.print(i+" ");
      }
	}

}
