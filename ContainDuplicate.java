package com.wgcris.LeetcodeAlgorithm;

import java.util.HashSet;
import java.util.Set;

/*
 * ��������Ƿ����ظ���Ҫ��ʱ�临�Ӷ�O(n)
 * ˼·��1�� ����set���ϣ����費�ظ����ص�
 * 2��������Ȼ���������������ж�
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
	 * ������Ȼ�����ڱȽϣ������ȣ������ظ�������true��������ȣ���û���ظ�
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
