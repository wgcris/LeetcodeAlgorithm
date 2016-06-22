package com.wg.leetcode;
/*
 *合并数组
 */
public class MergeList {
	
   public static void mergeList(int[] nums1,int[]nums2){
	   //定义辅助空间
	   int n1=nums1.length;
	   int n2=nums2.length;
	   int[] merge=new int[n1+n2];
	   int index1=0;
	   int index2=0;
	   int k=0;
	 
		   while(index1<n1 && nums1[index1]<nums2[index2]){
			   merge[k++]=nums1[index1];
			   index1++;
		   }
		   while(index2<n2 && nums1[index1]>nums2[index2]){
			   merge[k++]=nums2[index2];
			   index2++;			   
		   }
		   while(index1<n1){
			   merge[k++]=nums1[index1];
			   index1++;
		   }
		   while(index2<n2){
			   merge[k++]=nums2[index2];
			   index2++;
		   }
	   
	   
	   for(int num:merge){
		   System.out.print(num+" ");
	   }
   }
}
