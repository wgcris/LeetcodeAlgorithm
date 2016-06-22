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
   * ˼·��������Ŀһ,˼·�ܼ�,̰��,ֻ��Ҫʱ�̼���ǰλ�ú͵�ǰλ������������Զ����,��ʼ�պ�n���ȽϾͿ���:
   1,��������posλ�ó���maxstepΪ0�����,��˵���޷�������ǰ�ƶ�,����false
   2.��������posλ�ó���maxstep+pos>=n˵������������һ��,����true
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
	
	//������С����
	public  static int jump(int[] nums){
		int ret=0;//��ǰ����
		int cur=0;//��ǰ�ɴ���Զ����
		int last=0;// ��һ���ɴ���Զ����
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
    	//private ����ֻ���ڱ�����ʹ��
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
