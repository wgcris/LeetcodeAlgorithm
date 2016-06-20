package com.wgcris.LeetcodeAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wg.offerAlgorithm.Serial;

/*
 * 两个数组重叠部分：例如a={1,2,2,1},b={2,2},return [2];
 */

public class InterSection {
    
	/**
	 * 两个数组交集，去重
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int[] intersection(int[] num1,int[] num2){
		if(num1==null||num2==null)return null;
		Set<Integer> set=new HashSet<Integer>();
		Set<Integer> interSet=new HashSet<Integer>();
		for(int i=0;i<num1.length;i++){
			set.add(num1[i]);
		}
		for(int i=0;i<num2.length;i++){
			if(set.contains(num2[i])){
				interSet.add(num2[i]);
			}
		}
		
		int[] result=new int[interSet.size()];
		int i=0;
		for(Integer num:interSet){
			result[i++]=num;
		}
		return result;
	}
	
	/**
	 * 两个数组交集，不去重，例如{1,2,2,1}，{2,2} 交集为{2,2}  
	 * 利用hashmap，先存储第一个数组，得到每个数对应的个数，然后遍历第二个数组，如果存在就添加到list中，同时将个数减一，
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int[] interSection(int[] num1,int[]num2){
		
		if(num1==null||num2==null) return null;
			
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<num1.length;i++){
			if(map.containsKey(num1[i])){
				map.put(num1[i], map.get(num1[i])+1);
			}else{
				map.put(num1[i], 1);
			}
		}
		
		for(int i=0;i<num2.length;i++){
			if(map.containsKey(num2[i])&& map.get(num2[i])>0){
				list.add(num2[i]);
				map.put(num2[i], map.get(num2[i])-1);
			}
		}
      int[] result=new int[list.size()];
      int i=0;
	  for(Integer num:list){
		  result[i++]=num;
	  }	
		return result;
		
	}
	public static void print(int[] array){
		for(int i:array){
			System.out.print(i+" ");
		}
	}
	public static void main(String[] args){
		int[] num1={4,9,5};
		int[] num2={9,4,9,8,4};
		print(interSection(num1,num2));
	}
}
