package com.wg.leetcode;
/*
 * 88.�ϲ��������飬������������num1,num2,����num1�Ŀռ����������������֮�ͣ�����num2�ϲ���num1��
 */
public class MergeSortedArray {
	/**
	 * ˼·���ȷ���m+n��С�ռ䣬Ȼ���ÿ������ĩβ��ʼ�Ƚϣ�һ�ν����ֵ��������num1�У�˳���Һ���ǰ����
	 * @param num1
	 * @param m
	 * @param num2
	 * @param n
	 */
    public void merge(int[]num1,int m,int[]num2,int n){
    	int index1=m-1;
    	int index2=n-1;
    	int k=m+n-1;
    	while(index1>=0 && index2>=0){
    		if(num1[index1]>num2[index2]){
    			num1[k--]=num1[index1];
    			index1--;
    		}
    		else{
    			num1[k--]=num2[index2];
    			index2--;
    		}

    	}
    		while(index2>=0){
    			num1[k--]=num2[index2];
    			index2--;
    		}
    	
    }
}
