package com.wg.leetcode;



/*
 * 55.jump game 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.
For example:
A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false.
 */
public class JumpGame {
  /**
   * 思路：对于题目一,思路很简单,贪心,只需要时刻计算前位置和当前位置所能跳的最远长度,并始终和n作比较就可以:
   1,若在任意pos位置出现maxstep为0的情况,则说明无法继续向前移动,返回false
   2.若在任意pos位置出现maxstep+pos>=n说明可以完成最后一跳,返回true
   * @param nums
   * @return
   */
	public  static boolean canJump(int[] nums){
		if(nums.length==0||nums.length==1)return true;
		int maxstep=nums[0];
		for(int i=1;i<nums.length;i++){
			if(maxstep==0)return false;
			maxstep--;
			if(maxstep<nums[i])maxstep=nums[i];
			if(maxstep+i>=nums.length-1)return true;
		}
		return false;
	}
	
	//给出最小跳数
	public  static int jump(int[] nums){
		int ret=0;//当前跳数
		int cur=0;//当前可达最远距离
		int last=0;// 上一跳可达最远距离
		for(int i=0;i<nums.length;i++){
			if(i>cur)return -1;
			if(i>last){
				last=cur;
				ret++;
			}
			cur=Math.max(cur,i+nums[i]);
		}
		return ret;
	}
	
    public static void main(String[] args){
    	TestDemo demo =new TestDemo(88);
    	//private 修饰只能在本类中使用
	//	System.out.println(demo.count);
    	
    }
}

class TestDemo{
	private int count;
	public TestDemo(int a) {
		// TODO Auto-generated constructor stub
	 count=a;
	}
	
	public static void main(String[] args){
		TestDemo demo =new TestDemo(88);
		System.out.println(demo.count);
	}
}
