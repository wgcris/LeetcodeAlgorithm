package com.wgcris.LeetcodeAlgorithm;

import java.util.HashSet;
import java.util.Set;

/*
 * 检查数组是否有重复，要求时间复杂度O(n)
 * 思路：1） 利用set集合，无需不重复的特点
 * 2）先排序，然后相邻两个进行判断
 */
public class ContainDuplicate {

	public static boolean containDuplicate(int[] nums){
	
		Set<Integer> distinct=new HashSet<Integer>();
		for(int num:nums)
		{
			if(distinct.contains(nums))
				return true;
			else{
				distinct.add(num);
			}
		}
		return false;
		
	}
	/**
	 * 先排序，然后相邻比较，如果相等，则有重复，返回true，如果不等，则没有重复
	 * @param nums
	 * @return
	 */
	public static boolean containDuplicate1(int[] nums){
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
