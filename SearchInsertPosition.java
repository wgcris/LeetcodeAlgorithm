package com.wg.leetcode;
/*
 * 35,�����������飬��һ��Ŀ��ֵ��������������ҵ�Ŀ��ֵ�򷵻��±����û�У��򷵻ظ�Ŀ��ֵ������±�
 */
public class SearchInsertPosition {
  
	/**
	 * ˼·�����ö��ֲ���
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int searchInsert(int[] nums,int target){
		if(nums==null||nums.length<1)return -1;
		int low=0;
		int high=nums.length-1;
		int mid=0;
		while(low<=high){
			mid=low+(high-low)/2;
			if(nums[mid]==target)return mid;
			else if(nums[mid]>target){
				high=mid-1;
			}else{
				low=mid+1;
			}
	   }
		return low;
			
	}
	/*
	 * ��дһ�����ֲ���
	 */
	public static int binarySearch(int[] nums,int key){
		if(nums==null||nums.length<1)return -1;
		int low=0;
		int high=nums.length-1;
		int mid=0;
		while(low<=high){
			mid=low+(high-low)/2;
			if(nums[mid]==key) return mid;
			else if(nums[mid]<key) low=mid+1;
			else{
				high=mid;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args){
		int[] array={1,2,4,5,6};
		int target=0;
		System.out.println(searchInsert(array, target));
//		System.out.println(binarySearch(array, 7));
	}
}
