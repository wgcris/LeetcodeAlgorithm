package com.wgcris.LeetcodeAlgorithm;
/*
 * �������е�����0�Ƶ���������棬ͬʱ��֤���˳�򲻱�
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
