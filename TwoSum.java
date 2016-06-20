package com.wgcris.LeetcodeAlgorithm;

import java.util.HashMap;
import java.util.Map;

/*
 * leetcode: TwoSum:����n�������ҳ���Ϊһ���ض����������������������±ꡣ 
 */

public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] arr ={2,6,11,15};
       int target = 13;
     
       int[] result = twoSum1(arr,target);
       System.out.println(result[0]+" "+result[1]);
        
     
	}
   
	public static HashMap<Integer,Integer> twoSum(int[] arr,int target){
		//int[]Ϊ���������飬targetΪ�ض�Ŀ����
		HashMap<Integer,Integer>hm =new HashMap<Integer,Integer>();
		int k=1;
		for(int i=0;i<arr.length;i++){
			
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]+arr[j]==target){				  
				   hm.put(k, i+1);
				   k++;
				   hm.put(k,j+1);
                   k++;
				   break;
				}
			}			
		}
		return hm ;
	} 
	
	public static int[] twoSum1(int[] arr,int target){
		int[] result=new int[2];
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		
		for(int i=0;i<arr.length;i++){
			hm.put(arr[i], i);
		}
		for(int i=0;i<arr.length;i++){
			int gap =target-arr[i];
			if(hm.get(gap)!=null&&hm.get(gap)!=i){
				result[0]=i+1;
				result[1]=hm.get(gap)+1;
			}
		}
		return result;
	}
}
