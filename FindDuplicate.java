package com.wgcris.LeetcodeAlgorithm;
/*
 * 287: 给定一个数组，找到数组中重复的元素，假设数组中有且仅有一个元素有重复
 * 要求：1.数组只读，即不能修改数组元素
 *     2.不能借助辅助空间，只能使用常量，
 *     3，时间复杂度小于O(n^2)
 *     4.仅有一个元素有重复，但可以重复多次
 */
public class FindDuplicate {

	/**
	 * 思路1：核心思想把数组当成链表处理，寻找数组中的重复元素，也就是找到链表中环的入口节点。
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
			//当slow==fast时，找到入口元素
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
	 * 思路：利用二分查找，小于等于mid值得元素个数如果大于mid，则说明lower part 存在重复，否则upper part 存在重复
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
	 * 辅助函数，统计数组中小于目标值的元素个数
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
