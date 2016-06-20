package com.wgcris.LeetcodeAlgorithm;
/*
 * 题意：一个整数按位存储于一个int数组中，排列顺序为：最高位在array[0] ，最低位在[n-1]，例如：98，存储为：array[0]=9; array[1]=8;
解题思路，从数组的最后一位开始加1，需要考虑进位，如果到[0]位之后仍然有进位存在，需要新开一个长度为(n.length + 1)的数组，拷贝原来的数组。
 */
public class PlusOne {
   public static int[] plusOne(int[] digits){
	   int len=digits.length;
	   int flag=1;
	   for(int i=len-1;i>=0;i--){
		   digits[i]=digits[i]+flag;
		   if(digits[i]>9){
			   flag=1;
			   digits[i]=0;
		   }
		   else{
			   flag=0;
			   digits[i]=digits[i];
		   } 
	   }
	   int[] result;
	   if(flag!=0){
		    result=new int[len+1];
		   for(int i=1;i<result.length;i++){
			   result[i]=digits[i-1];
		   }
		   result[0]=1;
	   } else{
		   return digits;
	   }
	   
	   return result;
   }
   
   public static void main(String[] main){
	   int[] digits={9,8};
	   int[] digits1={9,9};
	   int[] result=plusOne(digits1);
	   for(int i:result){
		   System.out.print(i+" ");
	   }
   }
}
