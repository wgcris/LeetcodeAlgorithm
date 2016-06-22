package com.wg.leetcode;
/*
 * ���������������Ƴ��ظ���Ԫ��,����ȥ�ظ������鳤��,eg:[1,1,2],����2
 * ˼·��1��ʹ��set ���ϣ�set��������Ԫ�ز������ظ�
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
