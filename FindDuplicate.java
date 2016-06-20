package com.wgcris.LeetcodeAlgorithm;
/*
 * 287: ����һ�����飬�ҵ��������ظ���Ԫ�أ��������������ҽ���һ��Ԫ�����ظ�
 * Ҫ��1.����ֻ�����������޸�����Ԫ��
 *     2.���ܽ��������ռ䣬ֻ��ʹ�ó�����
 *     3��ʱ�临�Ӷ�С��O(n^2)
 *     4.����һ��Ԫ�����ظ����������ظ����
 */
public class FindDuplicate {

	/**
	 * ˼·1������˼������鵱��������Ѱ�������е��ظ�Ԫ�أ�Ҳ�����ҵ������л�����ڽڵ㡣
	 * @param nums
	 * @return
	 */
	public static int findDuplicate(int[] nums){
		if(nums.length >1){
			int slow=nums[0];
			int fast=nums[nums[0]];
			while(slow!=fast){
				slow=nums[slow];
				fast=nums[fast];
			}
			//��slow==fastʱ���ҵ����Ԫ��
			fast=0;
			while(fast!=slow){
				fast=nums[fast];
				slow=nums[slow];
			}
			return slow;
		}
		return -1;
		
	}
	/**
	 * ˼·�����ö��ֲ��ң�С�ڵ���midֵ��Ԫ�ظ����������mid����˵��lower part �����ظ�������upper part �����ظ�
	 * @param nums
	 * @return
	 */
	public static int findDuplicate1(int[] nums){
		int low=0;
		int high=nums.length-1;
		int mid=0;
		while(low<high){
			mid=low+(high-low)/2;
			int count=count(nums, mid);
			if(count>mid) high=mid;
			else low=mid+1;
		}
		return low;
	}
	/**
	 * ����������ͳ��������С��Ŀ��ֵ��Ԫ�ظ���
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int count(int[] nums, int target){
		int count=0;
		for(int num:nums){
			if(num<=target)count++;
		}
		return count;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
