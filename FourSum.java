package com.wg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/*
 * 18:����һ�����飬ȡ���������ĸ�����ʹ֮��Ϊһ����ֵ����3SumΪ����
 */
public class FourSum {
   
		public static List<List<Integer>> fourSum(int[] nums, int target) {
         List<List<Integer>> result= new ArrayList<List<Integer>>();
         if(nums==null || nums.length<4) return result;
         Arrays.sort(nums);
         for(int i=0;i<nums.length-3;i++){
        	 if(i>0 &&nums[i]==nums[i-1])continue;
        	 for(int j=i+1;j<nums.length-2;j++){ 
        		if(j>i+1 && nums[j]==nums[j-1])continue;
        		int tar=target-(nums[i]+nums[j]); 
        		 int p=j+1;
            	 int q=nums.length-1;
            	 while(p<q){
            		 if(nums[p]+nums[q]==tar){
            			 result.add(Arrays.asList(nums[i],nums[j],nums[p],nums[q]));
            			//�����ظ�
             			while(p<q && nums[p]==nums[p+1]) p++;
             			while(p<q && nums[q]==nums[q-1]) q--;
            			 p++;
            			 q--;
            		 }else if(nums[p]+nums[q]<tar){
            			 p++;
            		 }else{
            			 q--;
            		 }
            	 }
        	 } 
         }
         return result;
    }
		
		public static void main(String[] args){
			
			int nums[]={0,0,0,0};
					
			int target =0;
			 List<List<Integer>> result= fourSum(nums,target);
			 for(List<Integer> list:result){
				 for(Integer i:list){
					 System.out.print(i+" ");
				 }
				 System.out.println();
			 }
		}
}
