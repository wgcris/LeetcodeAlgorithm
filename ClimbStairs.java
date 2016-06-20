package com.wgcris.LeetcodeAlgorithm;
/*
 * 爬楼梯 一次爬1或者2 求有多少种方式：费波纳茨递归
 */

public class ClimbStairs {
   public static int climbStairs(int n){
	   int result[]={1,2};
       if(n<=2)
           return result[n-1];     
       int num_1=1;
       int num_2=2;
       int num=0;
       if(n>2){
          for(int i=2;i<n;i++){
              num=num_1+num_2;
              num_1=num_2;
              num_2=num;
          } 
           
       }
        return num;
   }
   //三行代码实现
   public int clibStairs(int n){
	   int a=1,b=1;
	   while(n-->0){
		   a=(b+=a)-a;
		   
	   }
	   return a;
   }
   
   public static void main(String[] args){
	 //  System.out.println(climbStairs(4));
	   
   }
}
