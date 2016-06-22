package com.wg.leetcode;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sun.tools.jar.resources.jar;

/*
 * 15：给定一个数组，选择其中三个数，使三个数之和为0，求出所有的组合
 * 思路: 先对数组进行排序，先固定一个元素，再在从后面的元素中找到和为0的元素，利用两个指针从数组两边继续比较
 */
public class ThreeSum {
 
	public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> resultList =new ArrayList<List<Integer>>();
        if(nums.length<3 || nums==null) return resultList;
        //先排序
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
        	//跳过重复
        	if(i>0 && nums[i]==nums[i-1]) continue;
        	int target=0-nums[i];
        	//定义两个指针
        	int p=i+1;
        	int q=nums.length-1;
        	while(p<q){
        		if(nums[p]+nums[q]==target){
        			resultList.add(Arrays.asList(nums[i],nums[p],nums[q]));
        			//跳过重复
        			while(p<q && nums[p]==nums[p+1]) p++;
        			while(p<q && nums[q]==nums[q--]) q--;
        			p++;
        			q--;
        		}else if(nums[p]+nums[q]<target){
        			p++;
        		}else{
        			q--;
        		}
        	}
        }
        return resultList;
    }
	
}
