package com.wg.leetcode;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sun.tools.jar.resources.jar;

/*
 * 15������һ�����飬ѡ��������������ʹ������֮��Ϊ0��������е����
 * ˼·: �ȶ�������������ȹ̶�һ��Ԫ�أ����ڴӺ����Ԫ�����ҵ���Ϊ0��Ԫ�أ���������ָ����������߼����Ƚ�
 */
public class ThreeSum {
 
	public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> resultList =new ArrayList<List<Integer>>();
        if(nums.length<3 || nums==null) return resultList;
        //������
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
        	//�����ظ�
        	if(i>0 && nums[i]==nums[i-1]) continue;
        	int target=0-nums[i];
        	//��������ָ��
        	int p=i+1;
        	int q=nums.length-1;
        	while(p<q){
        		if(nums[p]+nums[q]==target){
        			resultList.add(Arrays.asList(nums[i],nums[p],nums[q]));
        			//�����ظ�
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
