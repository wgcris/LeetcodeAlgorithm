package com.wg.leetcode;
/*
 * 88.合并有序数组，假设两个数字num1,num2,而且num1的空间可以容纳两个数组之和，即将num2合并到num1中
 */
public class MergeSortedArray {
	/**
	 * 思路：先分配m+n大小空间，然后从每个数组末尾开始比较，一次将最大值放入数组num1中，顺序右后往前进行
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
