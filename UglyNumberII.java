package com.wgcris.LeetcodeAlgorithm;

import java.util.ArrayList;
import java.util.List;

/*
 * 找到第n个丑数
 *  定义三个factors
 * (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
   (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
   (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
 */
public class UglyNumberII {

	public static int nthUglyNumber(int n){
		int factor2=0;
		int factor3=0;
		int factor5=0;
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		while(list.size()<n){
			int min_value=Math.min(Math.min(list.get(factor2)*2, list.get(factor3)*3), list.get(factor5)*5);
			list.add(min_value);
			if(list.get(factor2)*2==min_value)factor2++;
			if(list.get(factor3)*3==min_value)factor3++;
			if(list.get(factor5)*5==min_value)factor5++;
		}
		return list.get(list.size()-1);
		
	}
}
