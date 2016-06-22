package com.wg.leetcode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/*
 * 	27:�Ƴ�Ԫ��
 * Given an array and a value, remove all instances of that value in place and return the new length.
   Do not allocate extra space for another array, you must do this in place with constant memory.
  The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
   /**
    * ��һ�ַ�������moveZeros����һ������������Ƚϣ��������index��1��Ȼ�󷵻�index��ʱ�临�Ӷ�O(n)
    * @param nums
    * @param val
    * @return
    */
	public static  int removeElement(int[]nums,int val){
		if(nums==null||nums.length==0) return 0;
		int index=0;
		for(int num:nums){
			if(num!=val) nums[index++]=num;
		}
		return index;
	} 
	/**
	 * ��������ָ��
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int removeElement1(int[]nums,int val){
	 int index1=0;
	 int index2=nums.length-1;
	 //���ַ�ʽ������
	/* while(index1<=index2){
		 if(nums[index1]!=val) index1++;
		 else if(nums[index2]==val) index2--;
		 else{
			 //����
			 int temp=nums[index1];
			 nums[index1++]=nums[index2];
			 nums[index2--]=temp;
		 }
	 }*/
	 while(index1<=index2){
		 while(index1<index2 && nums[index1]!=val)index1++;
		 while(index1<index2 && nums[index2]==val)index2--;
		 //����
		 int temp=nums[index1];
		 nums[index1++]=nums[index2];
		 nums[index2--]=temp;
	 }
	 return index1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] nums={3,2,4,2,3};
     System.out.println(removeElement(nums, 3));
	}

}
