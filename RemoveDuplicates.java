package com.wg.leetcode;
/*
 * 从有序数组里面移除重复的元素,返回去重复后数组长度,eg:[1,1,2],返回2
 * 思路：1）使用set 集合，set集合里面元素不允许重复
 *     2)
 */

public class RemoveDuplicates {

	 public static int removeDuplicates(int[] nums) {
	        if(nums==null || nums.length==0) return 0;
	        int index=0;
	        for(int i=1;i<nums.length;i++){
	        
	        	if(nums[i]!=nums[index]){
	        		nums[++index]=nums[i];
	        		//index++;
	        	
	        	}else{
	        		  nums[index]=nums[i];
	        	}
	        		
	        }
	       
	        return index+1;
	    }
	 
	 public static int removeDuplicates1(int[] nums){
		 if(nums==null || nums.length==0) return 0;
		 int index=0;
		 for(int num:nums){
			 if(index==0||num>nums[index-1]){
				 nums[index++]=num;
			 }
		 }
		 return index;
	 }
	 
	 public static void main(String[] args){
		 int[] nums={1,1,1,2,3};
		 System.out.println(removeDuplicates1(nums));
		 
	 }
}
