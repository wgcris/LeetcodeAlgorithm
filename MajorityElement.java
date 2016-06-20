package com.wgcris.LeetcodeAlgorithm;

import java.util.*;
import java.util.Map.Entry;

/*
 * 给定一个大小为n的数组，找到其中一个元素出现次数超过n/2
 */
public class MajorityElement {

	public static void majorityElement(int[] nums){
	//	int result=0;
		HashMap<Integer, Integer> map=new HashMap<Integer,Integer>();
		int times=0;
		for(int num:nums){
			if(map.containsKey(num)){
				times=map.get(num);
//				if(times>=nums.length/2)
//					return num;
				
				map.put(Integer.valueOf(num), times+1);				
			}
			else{
				map.put(Integer.valueOf(num), 1);
			}
		}
		
		Set<Entry<Integer,Integer>>entrySet = map.entrySet();
		for(Entry<Integer,Integer>entry:entrySet){
			if(entry.getValue()>=nums.length/2)
				System.out.println(entry.getKey());
		}
//		
//		Collection<Integer> value= map.values();
//		for(int i:value){
//			if(i>=nums.length/2){
//				result=i;
//				break;
//			}
//		}
		

	}
	//这个解法牛逼
	public static int majorityElement_1(int[] num){
		int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int[] nums={1,2,3,5,5,6,5,5,44,5,5,5,5,4};
    System.out.println(majorityElement_1(nums));
	}

}
