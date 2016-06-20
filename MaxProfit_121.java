package com.wgcris.LeetcodeAlgorithm;
/*
 * leetcode：121题，
 * For example:
[1,2,3,4] ==> returns 3 (buy at 1 and sell at 4)
[4,3,2,1] ==> returns 0 (don't buy)
[4,10,25,2,10] ==> returns 21 (buy at 4 and sell at 25)
 */
/*
 * leetcode 122 题
 * 允许buy and sell 多次，但不能同时进行
 * 
 */
public class MaxProfit_121 {
   /**
    * 复杂度太高O(n^2)
    * @param prices
    * @return
    */
	public static int maxProfit(int[] prices){
		if(prices==null) return 0;
		int curNum=0;
		int result=0;
		int buyindex=0;
		int sellindex=0;
		for(int i=0;i<prices.length-1;i++){
			for(int j=i+1;j<prices.length;j++){
				curNum=prices[j]-prices[i];
				if(curNum>0 && curNum>result){
					result=curNum;
					buyindex=i+1;
					sellindex=j+1;
				}
			}
		}
		
		System.out.println("买入时间："+buyindex+" "+"卖出时间："+sellindex);
		return result;
	}
	/**
	 * 动态规划解决
	 * @param prices
	 * @return
	 */
	public static int maxProfit1(int[] prices){
		if(prices==null) return 0;
		int maxCur=0;
		int maxSofar=0;
		for(int i=1;i<prices.length;i++){
			maxCur=Math.max(0,maxCur+=prices[i]-prices[i-1]);
			maxSofar=Math.max(maxCur, maxSofar);
			
		}
		return maxSofar;
		
	}
	
	public static int maxProfit2(int[] prices){
		int total=0;
		for(int i=0;i<prices.length-1;i++){
			if(prices[i+1]>prices[i]) total+=prices[i+1]-prices[i];
		}
		return total;
	}
	public static void main(String[] args){
		int[] prices={4,10,25,2,10};
		System.out.println(maxProfit1(prices));
	}
}
